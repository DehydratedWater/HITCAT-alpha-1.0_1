package tools;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MapLoader {
	private TmxMapLoader maploader;
	private TiledMap map;
	private ArrayList <TiledMap> maps;
	private HashMap <String, Integer> indexes;
	
	public MapLoader(){
		map = new TiledMap();
		maploader = new TmxMapLoader();
		maps = new ArrayList<TiledMap>();
		indexes = new HashMap<String, Integer>();
		
	}
	
	public void loadMap(String name){
		maps.add(maploader.load("assets/"+name+".tmx"));
		
	}
	
	public TiledMap getMap(String name){
		return maps;
	}

}
