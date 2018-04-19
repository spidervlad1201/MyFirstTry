package com.vakuor.firsttry.controls;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.vakuor.firsttry.view.GameScreen;

public class PlayerController extends Controls {

    private float playerSpeed = 0;
    private float velocity = 3f;
    private float stopvelocity = 9f;
    private float speedMax = 10f;
    private float rotationSpeed = 0f;

    //private Polygon playerBounds;

    public PlayerController(Polygon playerBounds) {
        super(playerBounds);
        setParameters(velocity,stopvelocity,speedMax);
        //this.playerBounds = playerBounds;
        //super(objectBounds);
    }

}
