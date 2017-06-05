package com.hitcat.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hitcat.Hitcat;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Hitcat.title;
		config.width = Hitcat.S_WIDTH;
		config.height = Hitcat.S_HEIGHT;
		new LwjglApplication(new Hitcat(), config);
	}
}
