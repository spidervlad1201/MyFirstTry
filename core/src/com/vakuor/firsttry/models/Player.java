package com.vakuor.firsttry.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vakuor.firsttry.controls.CarController;
import com.vakuor.firsttry.controls.PlayerController;

public class Player extends GameObject {

    private CarController carController;
    private PlayerController playerController;
    public Player(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        //carController = new CarController(bounds);
        playerController = new PlayerController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        //carController.handle();
        playerController.handle();
    }
}
