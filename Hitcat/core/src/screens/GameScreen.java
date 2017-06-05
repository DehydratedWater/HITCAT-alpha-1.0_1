package screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
<<<<<<< HEAD
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
=======
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hitcat.GameConstants;
>>>>>>> 1742b6cfca20cc79b4829f4b4855e5fa501ee2af
import com.hitcat.Hitcat;

public class GameScreen implements Screen, GameConstants{
	
	private Hitcat game;
	private TiledMap map;
<<<<<<< HEAD
	private IsometricTiledMapRenderer renderer;
	private World world;
	private Box2DDebugRenderer b2dr;
=======
	private AssetManager assetManager;
	private Camera cam;
	private World world;
	private Box2DDebugRenderer b2rend;
	private FitViewport viewPort;
>>>>>>> 1742b6cfca20cc79b4829f4b4855e5fa501ee2af
	
	
	public GameScreen(Hitcat game){
		this.game = game;
		this.assetManager = game.assManager;
		
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
