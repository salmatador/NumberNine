package com.moonstub.numbernine.Core.GameScenes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.GameScenes.Menus.LevelSceneFragment;
import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneFragment;
import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneSubFragment;

/**
 * Created by desktop on 6/19/2016.
 */
public class LevelPickerScene extends GameScene {

    String[] TAGS = new String[]{"LEVEL_PICKER","NULL"};
    public LevelPickerScene(GameScreen screen, String tag) {
        super(screen, tag);

        //Load Menu Fragments
        addFragmentToMap(TAGS[0], new LevelSceneFragment());

        //SET FIRST FRAGMENT OF SCENE
        setFragment(getFragmentByTag(TAGS[0]), TAGS[0]);

    }

    @Override
    public void init() {
        attachFragment(getFragmentByTag(TAGS[0]));
    }
    @Override
    public void drawForeground() {
        Canvas c = new Canvas(getForeground());
        Paint p = new Paint();
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.FILL);
        c.drawRect(450,450,550,550,p);
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
