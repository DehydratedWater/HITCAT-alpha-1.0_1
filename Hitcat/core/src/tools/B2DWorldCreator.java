package tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

import routes.PolylineBossTracks;
import sprites.CircleObstacle;

public class B2DWorldCreator {

	private PolylineBossTracks bossTracks;
   
	public B2DWorldCreator(World world, TiledMap map){
		bossTracks = new PolylineBossTracks();
		
		for(MapObject object : map.getLayers().get(GameConstants.bossTracksLayer).getObjects().getByType(PolylineMapObject.class)){
			Polyline polyline = ((PolylineMapObject) object).getPolyline();
			bossTracks.addTrack(polyline);
		}
		
		for(MapObject object : map.getLayers().get(GameConstants.obstacleLayer).getObjects().getByType(EllipseMapObject.class)){
			Ellipse ellipse = ((EllipseMapObject) object).getEllipse();
			Circle circle = new Circle(ellipse.x, ellipse.y, ellipse.width);
			
			new CircleObstacle(world, map, circle);
			
			}
		
	}

}
