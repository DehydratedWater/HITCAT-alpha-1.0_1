package com.hitcat.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hitcat.GameConstants;
import com.hitcat.Hitcat;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameConstants.S_WIDTH;
		config.height = GameConstants.S_HEIGHT;
		config.title = GameConstants.title;
		new LwjglApplication(new Hitcat(), config);
	}
}
