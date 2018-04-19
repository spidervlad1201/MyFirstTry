package com.vakuor.firsttry.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.vakuor.firsttry.view.GameScreen;

public abstract class Controls {

    private float objectSpeed = 0;
    private float velocity = 3f;
    private float stopvelocity = 9f;
    private float speedMax = 10f;
//
//    public float Xtest = 0f;
//    public float Ytest = 0f;
    //    private float rotationSpeed = 30f;
    public int UP = Input.Keys.UP;
    public int DOWN = Input.Keys.DOWN;
    public int LEFT = Input.Keys.LEFT;
    public int RIGHT = Input.Keys.RIGHT;
    //Gdx.input.isKeyPressed(Input.Keys.LEFT


    private Polygon objectBounds;
//
//    public void setObjectSpeed(float objectSpeed) {
//        this.objectSpeed = objectSpeed;
//    }
//
//    public void setVelocity(float velocity) {
//        this.velocity = velocity;
//    }
//
//    public void setStopvelocity(float stopvelocity) {
//        this.stopvelocity = stopvelocity;
//    }
//
//    public void setSpeedMax(float speedMax) {
//        this.speedMax = speedMax;
//    }
//
//    public void setRotationSpeed(float rotationSpeed) {
//        this.rotationSpeed = rotationSpeed;
//    }

    public Controls(Polygon objectBounds) {
        this.objectBounds = objectBounds;
    }

    public void setParameters(float velocity, float stopvelocity, float speedMax){
        this.velocity = velocity;
        this.stopvelocity = stopvelocity;
        this.speedMax = speedMax;
    }

    public void handle() {

        acceleration(); // то, что связано со скоростью

//        rotation(); //то, что связано с поворотами

        objectSpeed = sliceSpeed();
//        Xtest = objectBounds.getX();
//        Ytest = objectBounds.getY();
        objectBounds.setPosition(objectBounds.getX() + MathUtils.cosDeg(objectBounds.getRotation()) * objectSpeed * GameScreen.deltaCff, objectBounds.getY() + MathUtils.sinDeg(objectBounds.getRotation()) * objectSpeed * GameScreen.deltaCff);
    }

//    private void move(){
//        if (Gdx.input.isKeyPressed(LEFT))
//            if (objectSpeed>=0)
//                objectSpeed +=velocity * GameScreen.deltaCff;
//            else
//                objectSpeed += stopvelocity * GameScreen.deltaCff;
//
//        else if ((Gdx.input.isKeyPressed(RIGHT)))
//            if (objectSpeed<0)
//                objectSpeed -=velocity * GameScreen.deltaCff;
//            else
//                objectSpeed -= stopvelocity * GameScreen.deltaCff;
//        else
//            downSpeed();
//    }

//    private void rotation(){
//        if (Gdx.input.isKeyPressed(LEFT))
//            objectBounds.rotate(rotationSpeed*objectSpeed*GameScreen.deltaCff);
//        else if ((Gdx.input.isKeyPressed(RIGHT)))
//            objectBounds.rotate(-rotationSpeed*objectSpeed*GameScreen.deltaCff);
//    }

    private void acceleration() {
        if (Gdx.input.isKeyPressed(RIGHT))
            if (objectSpeed >= 0)
                objectSpeed += velocity * GameScreen.deltaCff;
            else
                objectSpeed += stopvelocity * GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(LEFT))
            if (objectSpeed < 0)
                objectSpeed -= velocity * GameScreen.deltaCff;
            else
                objectSpeed -= stopvelocity * GameScreen.deltaCff;
        else
            downSpeed();
        //////////////////////
//
//        objectSpeed = sliceSpeed();
    }

    private void downSpeed() {   //гасим скорость
        if (objectSpeed > velocity * GameScreen.deltaCff)
            objectSpeed -= velocity * GameScreen.deltaCff;
        else if (objectSpeed < -velocity * GameScreen.deltaCff)
            objectSpeed += velocity * GameScreen.deltaCff;
        else
            objectSpeed = 0f;
    }


    private float sliceSpeed() {     //огран скорости
        if (objectSpeed > speedMax) {
            return speedMax;
        } else if (objectSpeed < -speedMax)
            return -speedMax;
        return objectSpeed;
    }
}