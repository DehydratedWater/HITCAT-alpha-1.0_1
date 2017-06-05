package com.hitcat;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.GameScreen;

public class Hitcat extends Game implements GameConstants
{		
	public SpriteBatch batch;
	public AssetManager assetManager;
	@Override
	public void create () {
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
