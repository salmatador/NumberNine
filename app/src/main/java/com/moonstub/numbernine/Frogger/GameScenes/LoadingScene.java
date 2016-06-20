package com.moonstub.numbernine.Frogger.GameScenes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Frogger.GameScenes.Menus.MenuSceneFragment;

/**
 * Created by desktop on 6/19/2016.
 */

//TODO ADD MORE MENU
//TODO CODE CLEANUP
//HANDLE BACK PRESS

public class LoadingScene extends GameScene {

    public LoadingScene(GameScreen screen, String tag) {
        super(screen, tag);

    }

    @Override
    public void init() {

    }

    @Override
    public void drawForeground() {
        Canvas c = new Canvas(getForeground());
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        c.drawRect(400,400,600,600,p);
    }

    @Override
    public void drawBackground() {
        Canvas c = new Canvas(getBackground());
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(45f);
        c.drawText("Loading...",50,50,p);
    }

}
