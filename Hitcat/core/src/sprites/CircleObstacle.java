package sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

public class CircleObstacle extends CircleInteractiveObject{

	public CircleObstacle(World world, TiledMap map, Circle bounds) {
		super(world, map, bounds);
		
		BodyDef bdef = new BodyDef();
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		
		bdef.type = BodyDef.BodyType.StaticBody;
		bdef.position.set((bounds.x + bounds.radius/2)/ GameConstants.PPM, (bounds.y+bounds.radius/2)/GameConstants.PPM);
		
         body = world.createBody(bdef);
		
		
		shape.setRadius(bounds.radius / 2 /GameConstants.PPM);
	    fdef.shape = shape;
	    body.createFixture(fdef);
	
	}

}
