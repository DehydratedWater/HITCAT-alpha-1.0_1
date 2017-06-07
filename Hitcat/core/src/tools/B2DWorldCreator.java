package tools;



import java.util.ArrayList;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.hitcat.GameConstants;

import routes.PolylineBossTracks;
import sprites.CircleObstacle;
import sprites.PolygonObstacle;
import sprites.RectangleObstacle;

public class B2DWorldCreator implements GameConstants {

	public ArrayList<PolygonObstacle> polygons;
	private PolylineBossTracks bossTracks;
    private World world;
    private TiledMap map;
	
	public B2DWorldCreator(World world, TiledMap map){
		this.world = world;
		this.map = map;
		
		polygons = new ArrayList<PolygonObstacle>();
		bossTracks = new PolylineBossTracks();
		
		
		
	}
	
	public void loadAllObjets(){
		for(MapObject object : map.getLayers().get(bossTracksLayer).getObjects().getByType(PolylineMapObject.class)){
			Polyline polyline = ((PolylineMapObject) object).getPolyline();
			bossTracks.addTrack(polyline);
		}
		
		for(MapObject object : map.getLayers().get(obstacleLayer).getObjects().getByType(EllipseMapObject.class)){
			Ellipse ellipse = ((EllipseMapObject) object).getEllipse();
			Circle circle = new Circle(ellipse.x, ellipse.y, ellipse.width);
			
			new CircleObstacle(world, map, circle);
			
			}
		
		for(MapObject object : map.getLayers().get(obstacleLayer).getObjects().getByType(RectangleMapObject.class)){
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			new RectangleObstacle(world, map, rect);
		
		}
		
		for(MapObject object : map.getLayers().get(obstacleLayer).getObjects().getByType(PolygonMapObject.class)){
			Polygon poly = ((PolygonMapObject) object).getPolygon();
			polygons.add(new PolygonObstacle(world, map, poly));
		
		}
	}

}
