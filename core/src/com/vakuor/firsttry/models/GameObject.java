package com.vakuor.firsttry.models;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    Sprite object;
    Rectangle bounds;

    GameObject(Texture texture, float x, float y, float width, float height){
        object = new Sprite(texture);
        bounds = new Rectangle(x,y,width,height);
    }

    public void draw(SpriteBatch batch){
        object.setBounds(bounds.getX(),bounds.getY(),bounds.getWidth(),bounds.getHeight());
        object.draw(batch);
    }
}
