package tools;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MapLoader 
{
	private TmxMapLoader maploader;
	private ArrayList <TiledMap> maps;
	private HashMap <String, Integer> indexes;
	private int index = 0;
	
	public MapLoader(){
		maploader = new TmxMapLoader();
		maps = new ArrayList<TiledMap>();
		indexes = new HashMap<String, Integer>();
		
	}
	
	public void addMap(String name){
		maps.add(maploader.load(name+".tmx"));
		indexes.put(name, index);
		index++;
		
	}
	
	public int getIndex(String name){
		return indexes.get(name);
	}
	
	public TiledMap getMap(int index){
		return maps.get(index);
	}
	
	public TiledMap getMap(String name){
		return maps.get((int)indexes.get(name));
	}

}
