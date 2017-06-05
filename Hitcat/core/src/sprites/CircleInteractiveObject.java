package sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public  abstract class CircleInteractiveObject {
	  protected World world;
	   protected TiledMap map;
	   protected TiledMapTile tile;
	   protected Circle bounds;
	   protected Body body;
	   
	   public CircleInteractiveObject(World world, TiledMap map, Circle bounds){
		   this.world = world;
		   this.map = map;
		   this.bounds = bounds;
		   
	   }

}
