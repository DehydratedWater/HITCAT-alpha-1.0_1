package routes;

import java.util.ArrayList;

import com.badlogic.gdx.math.Polyline;

public class PolylineBossTracks {
	public ArrayList<Polyline> tracks;
	
	public PolylineBossTracks(){
		tracks = new ArrayList<Polyline>();
	}
 
	public void addTrack(Polyline route){
		tracks.add(route);
	}
	
	public Polyline getTrack(int index){
		return tracks.get(index);
	}
	
	public void transformPolyline(int i)
	{
		
	}
}
