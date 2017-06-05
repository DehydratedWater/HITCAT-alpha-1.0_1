package tools;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;

public class TiledMapRenderer {
	private IsometricTiledMapRenderer renderer;
	private OrthographicCamera cam;
	
	public TiledMapRenderer(TiledMap map, OrthographicCamera cam, float scale){
		this.cam = cam;
		renderer = new IsometricTiledMapRenderer(map, scale);
	}
	
	public void render(){
		renderer.setView(cam);
		renderer.render();
	}
	
	public void dispose(){
		renderer.dispose();
	}

}
