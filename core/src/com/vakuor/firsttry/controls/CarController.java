package com.vakuor.firsttry.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.vakuor.firsttry.view.GameScreen;

public class CarController {

    private float carSpeed = 0;
    private float velocity = 3f;
    private float stopvelocity = 9f;
    private float speedMax = 10f;
    private float rotationSpeed = 30f;

    private Polygon carBounds;

    public CarController(Polygon carBounds){
        this.carBounds = carBounds;
    }


    public void handle(){

        acceleration(); // то, что связано со скоростью

        rotation(); //то, что связано с поворотами

        carSpeed = sliceSpeed();

        carBounds.setPosition(carBounds.getX()+ MathUtils.cosDeg(carBounds.getRotation()+90)* carSpeed *GameScreen.deltaCff,carBounds.getY()+MathUtils.sinDeg(carBounds.getRotation()+90)* carSpeed *GameScreen.deltaCff);
    }

    private void rotation(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            carBounds.rotate(rotationSpeed*carSpeed*GameScreen.deltaCff);
        else if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT)))
            carBounds.rotate(-rotationSpeed*carSpeed*GameScreen.deltaCff);
    }

    private void acceleration(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            if (carSpeed>=0)
                carSpeed +=velocity * GameScreen.deltaCff;
            else
                carSpeed += stopvelocity * GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            if (carSpeed<0)
                carSpeed -=velocity * GameScreen.deltaCff;
            else
                carSpeed -= stopvelocity * GameScreen.deltaCff;
        else
            downSpeed();
    }

    private void downSpeed(){   //гасим скорость
        if (carSpeed > velocity*GameScreen.deltaCff)
            carSpeed -= velocity*GameScreen.deltaCff;
        else if (carSpeed < -velocity*GameScreen.deltaCff)
            carSpeed += velocity*GameScreen.deltaCff;
        else
            carSpeed = 0f;
    }


    private float sliceSpeed(){     //огран скорости
        if (carSpeed > speedMax) {
            return speedMax;
        }
        else if (carSpeed < -speedMax)
            return -speedMax;
        return carSpeed;
    }
}
