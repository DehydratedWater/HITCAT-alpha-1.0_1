package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hitcat.GameConstants;
import com.hitcat.Hitcat;

import tools.MapLoader;

public class GameScreen implements Screen, GameConstants{
	
	private Hitcat game;
	private TiledMap map;
	private IsometricTiledMapRenderer renderer;
	private AssetManager assetManager;
	private OrthographicCamera cam;
	private World world;
	private Box2DDebugRenderer b2rend;
	private FitViewport viewPort;
	private SpriteBatch batch;
	private MapLoader maps;
	
	private float TRANSLATION = 1;
	
	
	
	private Texture testText;
	
	public GameScreen(Hitcat game){
		this.game = game;
		this.assetManager = game.assManager;
		
		maps = new MapLoader();
		
		maps.addMap("TileMaps");
		
		renderer = new IsometricTiledMapRenderer(maps.getMap("TileMaps"));
		
		cam = new OrthographicCamera();
		viewPort = new FitViewport(V_WIDTH, V_HEIGHT, cam);
		
		cam.position.set(viewPort.getWorldWidth()/2, viewPort.getWorldHeight()/2, 0);
		
		world = new World(new Vector2(0,0), true);
		b2rend = new Box2DDebugRenderer();
		
		batch = game.batch;
		
		testText = new Texture("Cat.png");
		
		
	}

	@Override
	public void show() 
	{
		
		
	}
	
	private void handleInput(float delta){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
	    	cam.translate(new Vector2(0, TRANSLATION));
    		
    	}
    	
    	if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
    		cam.translate(new Vector2(0, -TRANSLATION));
    	}
    	
    	if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
    		cam.translate(new Vector2(TRANSLATION, 0));
    	}
    	
    	if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
    		cam.translate(new Vector2(-TRANSLATION, 0));
    	}
		
	}

	private void draw(float delta)
	{
		Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		renderer.render();
		
		game.batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(testText, 100, 100);
		batch.end();
	}
	
	private void update(float delta)
	{
	cam.update();
	renderer.setView(cam);
     System.out.println(cam.position.x+" "+" "+cam.position.y);
	 handleInput(delta);	
	}
	
	@Override
	public void render(float delta) 
	{
		update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) 
	{
		cam.viewportWidth = width;
		cam.viewportHeight = height;
		
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
