package characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

import sprites.CircleInteractiveObject;

public class Cat extends CircleInteractiveObject implements GameConstants{
	public Sprite catSprite;
	public Body b2Body;
	
	private int RADIUS = 10;
	private final int CELL_SIZE = 64;
	private float START_X = 6.4f;
	private float START_Y = 3.6f;


	public Cat(World world, TiledMap map, Circle bounds) {
		super(world, map, bounds);
		defineBody();
		
		
		catSprite = new Sprite(new Texture("Cat.png"));
		catSprite.setPosition(b2Body.getPosition().x  - CELL_SIZE / 2 / PPM, b2Body.getPosition().y - CELL_SIZE/ 2 / PPM );
		catSprite.setSize(CELL_SIZE / PPM, CELL_SIZE / PPM);
		
	
		
		
	}
	
	public void update(){
		catSprite.setPosition(b2Body.getPosition().x  - CELL_SIZE / 2, b2Body.getPosition().y - CELL_SIZE/2 );
	}
	
	private void defineBody(){
		BodyDef bdef = new BodyDef();
		bdef.position.set(START_X/ PPM, START_Y/ PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2Body = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(RADIUS / PPM);
		fdef.shape = shape;
		fdef.density = 10;
		fdef.friction = 0.2f;
		
		b2Body.createFixture(fdef);
	}

}
