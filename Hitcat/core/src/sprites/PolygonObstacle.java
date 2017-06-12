package sprites;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

import tools.ToolBox;

public class PolygonObstacle extends PolygonInteractiveObject implements GameConstants{

	public PolygonObstacle(World world, TiledMap map, Polygon bounds) {
		super(world, map, bounds);

			ToolBox.setTileSize(map);
	        //float worldVertices[] = ToolBox.translateIsometricArray(bounds.getTransformedVertices());

			float worldVertices[] = ToolBox.scaleByPPM(bounds.getTransformedVertices());
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


