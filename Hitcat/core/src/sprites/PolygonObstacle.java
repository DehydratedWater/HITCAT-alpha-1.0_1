package sprites;

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
		
		
		//ustawianie punktu rotacji na środek mapy izometrycznej o wymiarach 20 x 20 kafelków
	  //  bounds.setOrigin((float)(64 * Math.sqrt(2)) / 2 / PPM, 0);
		bounds.setOrigin(bounds.getOriginX(), bounds.getOriginY());
	    
		bounds.rotate(-90);
		
		float vertices [] = bounds.getTransformedVertices();
	        
	        float worldVertices[] = new float[vertices.length];
	        
	       
	       
	        //transformacja do rzutu izometrycznego 
	        
	        float x, y;
	        
	        for(int i = 0; i < vertices.length; i+=2){
	        	vertices[i+1] += 20; //losowe przesunięcie bo czemu nie
	        	vertices[i] += 20;
	        	
	        	x = (vertices[i] - vertices[i+1]) ;
	        	y = (vertices[i] + vertices[i+1]) / 2;
	        	
	        	vertices[i] = x;
	        	vertices[i+1] = y;
	        	
	        }
	       
	        
	        //szkalowanie wierzchołków
	        
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


