package tools;




import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public class MapLoader 
{
  
	private AssetManager assetManager;
	private HashMap <String, Integer> indexes;
	private int index = 0;
	
	public MapLoader(AssetManager assetManager){
		this.assetManager = assetManager;
		assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		
		indexes = new HashMap<String, Integer>();
		
      
		
	}
	
	public void addMap(String name){
		assetManager.load(name+".tmx", TiledMap.class);
		assetManager.finishLoading();
		
		indexes.put(name, index);
		index++;
		
	}
	
	public int getIndex(String name){
		return indexes.get(name);
	}
	


	public TiledMap getMap(String name){
		return assetManager.get(name+".tmx");
	}

}
