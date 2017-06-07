package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hitcat.GameConstants;
import com.hitcat.Hitcat;

import characters.Cat;
import tools.B2DWorldCreator;
import tools.InputManager;
import tools.MapLoader;
import tools.TiledMapRenderer;

public class GameScreen implements Screen, GameConstants{
	
	private Hitcat game;
	private TiledMap map;
	private AssetManager assetManager;
	private OrthographicCamera cam;
	private World world;
	private Box2DDebugRenderer b2rend;
	private FitViewport viewPort;
	private SpriteBatch batch;
	private MapLoader maps;
	private InputManager inputManager;
	private TiledMapRenderer renderer;
	private Cat cat;
	private B2DWorldCreator b2dWorldCreator;
    private float SPEED= 4;
	private float TRANSLATION = 20 / PPM;	
	private float ZOOM = 5f / PPM;
	private boolean isCameraLocked = true;
	
	
	
	
	public GameScreen(Hitcat game){
		this.game = game;
		this.assetManager = game.assetManager;
		
		
		
		inputManager = new InputManager();
		
		Gdx.input.setInputProcessor(inputManager);
		
		
		maps = new MapLoader(assetManager);
		
		maps.addMap("TileMaps");
		
			
		cam = new OrthographicCamera();
		viewPort = new FitViewport(V_WIDTH/PPM, V_HEIGHT/PPM, cam);
		
		
		
		world = new World(new Vector2(0,0), true);
		b2rend = new Box2DDebugRenderer();
		
		batch = game.batch;
		
		b2dWorldCreator = new B2DWorldCreator(world, maps.getMap("TileMaps"));
		b2dWorldCreator.loadAllObjets();
		
		renderer = new TiledMapRenderer(maps.getMap("TileMaps"), cam,  1/PPM);	
		
		cat = new Cat(world, map, null);
		
		
		
		
		
		//sprite.scale(1/PPM);		
	}

	@Override
	public void show() 
	{
		
		
	}
	
	private void handleInput(float delta){
		if(inputManager.SCROLLED_UP){
	    	cam.zoom -= ZOOM;
	    	
    		
    	}
    	
		if(inputManager.SCROLLED_DOWN){
	    	cam.zoom += ZOOM;
    	}
		
		if(inputManager.RIGHT_BRACKET){
	    	TRANSLATION += 5 / PPM;
   
    	}
		
		if(inputManager.LEFT_BRACKET){
	    	TRANSLATION -= 5 / PPM;
    		
    	}
		
		if(inputManager.UP){
			cam.translate(new Vector2(0, TRANSLATION));
    		
    	}
    	
    	if(inputManager.DOWN){
    		cam.translate(new Vector2(0, -TRANSLATION));
    	}
    	
    	if(inputManager.RIGHT){
    		cam.translate(new Vector2(TRANSLATION, 0));
    	}
    	
    	if(inputManager.LEFT){
    		cam.translate(new Vector2(-TRANSLATION, 0));
    	}
    	
    	if(inputManager.W){
    		cat.b2Body.setLinearVelocity(0, SPEED * TRANSLATION);
    	}
    	
    	if(inputManager.S){
    		cat.b2Body.setLinearVelocity(0, -SPEED * TRANSLATION);
    	}
    	
    	if(inputManager.D){
    		cat.b2Body.setLinearVelocity(SPEED * TRANSLATION, 0);
    	}
    	
    	if(inputManager.A){
    		cat.b2Body.setLinearVelocity(-SPEED * TRANSLATION, 0);
    	}
    	
    	if(inputManager.W && inputManager.A ){
    		cat.b2Body.setLinearVelocity(-SPEED * TRANSLATION, SPEED * TRANSLATION);
    	}
    	
    	if(inputManager.W && inputManager.D ){
    		cat.b2Body.setLinearVelocity(SPEED * TRANSLATION, SPEED * TRANSLATION);
    	}
    	
    	if(inputManager.S && inputManager.A ){
    		cat.b2Body.setLinearVelocity(-SPEED * TRANSLATION, -SPEED * TRANSLATION);
    	}
    	
    	if(inputManager.S && inputManager.D ){
    		cat.b2Body.setLinearVelocity(SPEED * TRANSLATION, -SPEED * TRANSLATION);
    	}
    	
    	if(inputManager.BACKSPACE){
    		cat.b2Body.setLinearVelocity(0, 0);
    	}
    	
    	
    	if(inputManager.SPACE){
    		isCameraLocked = !isCameraLocked;
    	}
    	
    	if(inputManager.ESCAPE){
    		Gdx.app.exit();
    	}

		
	}

	private void draw(float delta)
	{
		Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        renderer.render();
		
        b2rend.render(world, cam.combined);
        
        
		game.batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		cat.catSprite.draw(batch);		
		batch.end();
	}
	
	private void update(float delta)
	{

   if(isCameraLocked){	
     cam.position.x = cat.b2Body.getPosition().x;
     cam.position.y = cat.b2Body.getPosition().y;
   }
	world.step(1/60f, 6, 2);
    
	cat.update();
	cam.update();
	//renderer.setView(cam);
    System.out.println(cam.position.x+" "+" "+cam.position.y);
	 handleInput(delta);	
	 inputManager.refreshInput();
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
		cam.viewportWidth = width/PPM;
		cam.viewportHeight = height/PPM;
		
		
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
		renderer.dispose();
		
	}

}
