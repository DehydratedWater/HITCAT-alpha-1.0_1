package screens;

import com.badlogic.gdx.Screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hitcat.GameConstants;

import com.hitcat.Hitcat;

import tools.MapLoader;

public class GameScreen implements Screen, GameConstants{
	
	private Hitcat game;
	private TiledMap map;
	private AssetManager assetManager;
	private Camera cam;
	private World world;
	private Box2DDebugRenderer b2rend;
	private FitViewport viewPort;
	private MapLoader maps;
	
	
	
	
	public GameScreen(Hitcat game){
		this.game = game;
		this.assetManager = game.assManager;
		
		maps = new MapLoader();
		
		cam = new OrthographicCamera();
		viewPort = new FitViewport(V_WIDTH, V_HEIGHT, cam);
	}

	@Override
	public void show() 
	{
		
		
	}

	@Override
	public void render(float delta) 
	{
		
		
	}

	@Override
	public void resize(int width, int height) 
	{
		
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
