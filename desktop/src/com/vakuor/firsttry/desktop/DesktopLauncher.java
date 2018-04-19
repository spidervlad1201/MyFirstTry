package com.vakuor.firsttry.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vakuor.firsttry.MyFirstTry;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 854;
		config.height = 480;

		new LwjglApplication(new MyFirstTry(), config);
	}
}
