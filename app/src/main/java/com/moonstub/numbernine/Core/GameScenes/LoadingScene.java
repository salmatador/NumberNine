package com.moonstub.numbernine.Core.GameScenes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.Framework.Tags;
import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneFragment;
import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneSubFragment;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/19/2016.
 */

//TODO ADD MORE MENU
//TODO CODE CLEANUP
//HANDLE BACK PRESS

public class LoadingScene extends GameScene {

    String[] TAGS = new String[]{"MAIN_MENU","MENU_OPTIONS","NULL"};

    public LoadingScene(GameScreen screen, String tag) {
        super(screen, tag);

        //Load Menu Fragments
        addFragmentToMap(TAGS[0], new MenuSceneFragment());
        addFragmentToMap(TAGS[1] ,new MenuSceneSubFragment());

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
