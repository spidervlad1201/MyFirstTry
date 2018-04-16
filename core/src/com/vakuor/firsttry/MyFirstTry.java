package com.vakuor.firsttry;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.vakuor.firsttry.view.GameScreen;

public class MyFirstTry extends Game {

	private Screen gameScreen;
	@Override
	public void create() {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
}
