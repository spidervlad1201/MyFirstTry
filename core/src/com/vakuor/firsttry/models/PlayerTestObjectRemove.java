package com.vakuor.firsttry.models;

import com.badlogic.gdx.graphics.Texture;
import com.vakuor.firsttry.controls.PlayerController;

public class PlayerTestObjectRemove extends GameObject {

    private PlayerController playerController;
    public PlayerTestObjectRemove(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        playerController = new PlayerController(bounds);
    }


}
