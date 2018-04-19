package com.vakuor.firsttry.utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    private AssetManager manager;

    public void Assets(){
        manager = new AssetManager();
        manager.load("knightAtlas.atlas", TextureAtlas.class);
        manager.finishLoading();
    }

    public AssetManager getManager() {
        return manager;
    }
    public void dispose(){
        manager.dispose();
    }
}
