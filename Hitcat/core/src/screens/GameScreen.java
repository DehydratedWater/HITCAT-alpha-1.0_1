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
import tools.ToolBox;

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
    private float SPEED = 10;
	private float TRANSLATION = 20 / PPM;	
	private float ZOOM = 5f / PPM;
	private boolean isCameraLocked = true;
	
	private float positon = 0;
	
	
	public GameScreen(Hitcat game){
		this.game = game;
		this.assetManager = game.assetManager;
		
		
		
		inputManager = new InputManager();
		
		Gdx.input.setInputProcessor(inputManager);
		
		
		maps = new MapLoader(assetManager);
		
		maps.addMap("TileMaps2");
		
			
		cam = new OrthographicCamera();
		viewPort = new FitViewport(V_WIDTH/PPM, V_HEIGHT/PPM, cam);
		
		
		
		world = new World(new Vector2(0,0), true);
		b2rend = new Box2DDebugRenderer();
		
		batch = game.batch;
		
		b2dWorldCreator = new B2DWorldCreator(world, maps.getMap("TileMaps2"));
		b2dWorldCreator.loadAllObjets();
		
		renderer = new TiledMapRenderer(maps.getMap("TileMaps2"), cam,  1/PPM);	
		
		cat = new Cat(world, map, null);
		
		
		
		
		
		//sprite.scale(1/PPM);		
	}

	@Override
	public void show() 
	{
		
		
	}
	
	private void handleInput(float delta){
		
		if(inputManager.PLUS){
	    	positon += 0.001f;
	    	if(positon>1)
				positon=1;
    	}
    	
		if(inputManager.MINUS){
			positon -= 0.001f;
			if(positon<0)
				positon=0;
    	}
		
		
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
		
		float movX = 0, movY = 0;
		
		if(inputManager.UP||inputManager.W){
			movY+=SPEED * TRANSLATION;
    		
    	}
    	
    	if(inputManager.DOWN||inputManager.S){
    		movY-=SPEED * TRANSLATION;
    	}
    	
    	if(inputManager.RIGHT||inputManager.D){
    		movX+=SPEED * TRANSLATION;
    	}
    	
    	if(inputManager.LEFT||inputManager.A){
    		movX-=SPEED * TRANSLATION;
    	}
    	
    	if(isCameraLocked)
    	 cat.b2Body.setLinearVelocity(movX, movY);
    	else{
    	 cam.position.x += movX / SPEED;
    	 cam.position.y += movY / SPEED;
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
		
        
        
        
		game.batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		cat.catSprite.draw(batch);		
		batch.end();
		
		b2rend.render(world, cam.combined);
	}
	
	private void update(float delta)
	{
	float pos[] = b2dWorldCreator.polylines.get(0).getPositionOnTrack(positon);
	pos = ToolBox.reverseIsometricTransform(pos);
	float pos2[] = ToolBox.reverseIsometricTransform(new float[]{pos[2], pos[3]});
	cat.b2Body.setTransform(pos[0], pos[1], 0);
	cat.b2Body.setLinearVelocity(pos2[0], pos2[1]);
	
//	System.out.println("Start point pos: "+pos[0]+" "+pos[1]);
//	System.out.println("Cat pos: "+cat.b2Body.getPosition());	
   if(isCameraLocked){	
     cam.position.x = cat.b2Body.getPosition().x;
     cam.position.y = cat.b2Body.getPosition().y;
   }
	world.step(1/60f, 6, 2);
    
	cat.update();
	cam.update();
	//renderer.setView(cam);
    //System.out.println(cam.position.x+" "+" "+cam.position.y);
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
