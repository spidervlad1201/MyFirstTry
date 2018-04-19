package com.vakuor.firsttry.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.vakuor.firsttry.models.Player;

public class GameScreen implements Screen {

    private Texture texture;
    private TextureAtlas textureAtlas;
    private SpriteBatch batch;
    private Player player;
    private OrthographicCamera camera;

    public static float deltaCff;

    @Override
    public void show() {

        texture = new Texture(Gdx.files.internal("googleart.png"));
        player = new Player(texture,0,0,1f,1f * 1f);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        batch = new SpriteBatch();
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height/width;
        camera = new OrthographicCamera(20f,20f*aspectRatio);
//        camera.zoom = 0.9f;
//        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
