package sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class PolygonInteractiveObject {
	 protected World world;
	   protected TiledMap map;
	   protected TiledMapTile tile;
	   protected Polygon bounds;
	   protected Body body;
	   
	   public PolygonInteractiveObject(World world, TiledMap map, Polygon bounds){
		   this.world = world;
		   this.map = map;
		   this.bounds = bounds;
	   }

}
