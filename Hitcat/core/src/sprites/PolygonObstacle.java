package sprites;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

public class PolygonObstacle extends PolygonInteractiveObject implements GameConstants{

	public PolygonObstacle(World world, TiledMap map, Polygon bounds) {
		super(world, map, bounds);
		
		
		//ustawianie punktu rotacji na œrodek mapy izometrycznej o wymiarach 20 x 20 kafelków
	    //bounds.setOrigin(20 * 64  / 2,  20 * 32  / 2);
		//bounds.setOrigin(bounds.getOriginX(), bounds.getOriginY());
	    
		//int mp = map.getProperties().get("hight", Integer.class);
		
//		bounds.translate(0,  -20 * 32);
		
		
		float vertices [] = bounds.getTransformedVertices();
	        
	        float worldVertices[] = new float[vertices.length];
	        
	        
	       
	       
	        //transformacja do rzutu izometrycznego 
	        
	        float x, y;
	        
	        int mapWidth = map.getProperties().get("width", Integer.class);
	        int mapHeight = map.getProperties().get("height", Integer.class);
	        int tilePixelWidth = map.getProperties().get("tilewidth", Integer.class);
	        int tilePixelHeight = map.getProperties().get("tileheight", Integer.class);
	        
	        
	        for(int i = 0; i < vertices.length; i+=2){
	        	
	        	vertices[i] -= tilePixelWidth/4;
	        	vertices[i+1] += tilePixelHeight/2; 
	        	
//	        	x = (vertices[i] - vertices[i+1]) ;
//	        	y = (vertices[i] + vertices[i+1]) / 2;
	        	
	        	x = (vertices[i] + vertices[i+1]);
	        	y = -(vertices[i] - vertices[i+1]) / 2;
	        	
	        	vertices[i] = x;
	        	vertices[i+1] = y;
	        	
	        }
	       
	        
	        //szkalowanie wierzcho³ków
	        
	        for(int i = 0; i < vertices.length; i++){
	        	worldVertices [i] = vertices[i] / PPM;
	        	System.out.println(vertices[i]);
	         
	        }
	        
	     
		   
			BodyDef bdef = new BodyDef();
			FixtureDef fdef = new FixtureDef();
			PolygonShape shape = new PolygonShape();
			
        
			bdef.type = BodyDef.BodyType.StaticBody;

			bdef.position.set(0, 0);
		   
			body = world.createBody(bdef);
			
			shape.set(worldVertices);
		    fdef.shape = shape;
		    body.createFixture(fdef);
		}
		
		
	}


