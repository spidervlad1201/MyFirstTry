package com.vakuor.firsttry.models;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    Sprite object;
    Polygon bounds;

    GameObject(Texture texture, float x, float y, float width, float height){
        object = new Sprite(texture);
        object.setSize(width,height);
        object.setOrigin(width/2,height/2);
        object.setPosition(x,y);

        bounds = new Polygon(new float[]{0f,0f,width,0f,width,height,0f,height});
        bounds.setPosition(x,y);
        bounds.setOrigin(width/2,height/2);
    }

    public void draw(SpriteBatch batch){
        object.setPosition(bounds.getX(),bounds.getY());
        object.setRotation(bounds.getRotation());
        object.draw(batch);
    }

    public Polygon getBounds() { return bounds; }
}
