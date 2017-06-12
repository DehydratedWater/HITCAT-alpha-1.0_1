package sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

import tools.ToolBox;

public class PolylineObstacle extends PolylineInteractiveObject implements GameConstants{

	public PolylineObstacle(World world, TiledMap map, Polyline bounds) {
		super(world, map, bounds);

			ToolBox.setTileSize(map);
	        //float worldVertices[] = ToolBox.translateIsometricArray(bounds.getTransformedVertices());
	        float worldVertices[] = ToolBox.scaleByPPM(bounds.getTransformedVertices());
			BodyDef bdef = new BodyDef();
			FixtureDef fdef = new FixtureDef();
			ChainShape shape = new ChainShape();
			
        
			bdef.type = BodyDef.BodyType.StaticBody;

			bdef.position.set(0, 0);
		   
			body = world.createBody(bdef);
			
			shape.createChain(worldVertices);
		    fdef.shape = shape;
		    fdef.isSensor = true;
		    body.createFixture(fdef);
		}
		
		
	}


