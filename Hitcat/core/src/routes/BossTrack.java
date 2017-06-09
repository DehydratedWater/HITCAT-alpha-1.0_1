package routes;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.physics.box2d.World;

import sprites.PolylineObstacle;
import tools.ToolBox;

public class BossTrack 
{
	public PolylineObstacle polyline;
	public float worldVertices[];
	public float length;
	public float[] segments;
	
	public BossTrack(World world, TiledMap map, Polyline bounds)
	{
		polyline = new PolylineObstacle(world, map, bounds);
		ToolBox.setTileSize(map);
		worldVertices = ToolBox.translateIsometricArray(bounds.getTransformedVertices());
		segments = new float[worldVertices.length/2-1];
		int index = 0;
		System.out.println("D³ugoœæ "+worldVertices.length);
		for(int i = 0; i < worldVertices.length-2; i+=2)
		{
			System.out.println(index);
			segments[index] = ToolBox.getDistanceBetwenPoints(worldVertices[i]/2, worldVertices[i+1], worldVertices[i+2]/2, worldVertices[i+3]);
			length+=segments[index];
			index++;
		}
		System.out.println("D³ugoœæ segmentów "+length);
	}
	
	public float[] getPositionOnTrack(float progress)
	{
//		System.out.println(progress);
		float usedTrack = length*progress;
		int index = 0;
		float checkTrack = 0;
		for(int i = 0; i < segments.length; i++)
		{
			if(checkTrack + segments[i] >= usedTrack)
			{
				index = i;
				break;
			}
			checkTrack+=segments[i];
		}
//		System.out.println("Przebyta trasa "+checkTrack+" z "+length);
		float diffrence = usedTrack-checkTrack;
		float segmentProportion = diffrence/segments[index];
		
		float mx = (worldVertices[index*2+2] - worldVertices[index*2])*segmentProportion;
		float my = (worldVertices[index*2+3] - worldVertices[index*2+1])*segmentProportion;
//		return new float[]{0, 0};
		return new float[]{worldVertices[index*2]+mx, worldVertices[index*2+1]+my, mx, my};
	}
}
