package com.vakuor.firsttry;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.vakuor.firsttry.utilities.Assets;
import com.vakuor.firsttry.view.GameScreen;

public class MyFirstTry extends Game {

	private Screen gameScreen;
	private Assets assets;
	@Override
	public void create() {
		assets = new Assets();
		gameScreen = new GameScreen();
		((GameScreen)gameScreen).setTextureAtlas(assets.getManager().get("knightAtlas.atlas", TextureAtlas.class));
		setScreen(gameScreen);
	}
}
