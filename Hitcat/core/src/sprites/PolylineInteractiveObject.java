package sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class PolylineInteractiveObject {
	 protected World world;
	   protected TiledMap map;
	   protected TiledMapTile tile;
	   protected Polyline bounds;
	   protected Body body;
	   
	   public PolylineInteractiveObject(World world, TiledMap map, Polyline bounds){
		   this.world = world;
		   this.map = map;
		   this.bounds = bounds;
	   }

}
