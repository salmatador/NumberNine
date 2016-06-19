package com.moonstub.numbernine.Core.GameScenes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneFragment;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/19/2016.
 */

//TODO ADD MORE MENU
//TODO CODE CLEANUP
//HANDLE BACK PRESS

public class LoadingScene extends GameScene {
    MenuSceneFragment mMenuSceneFragment;
    public LoadingScene(GameScreen screen, String tag) {
        super(screen, tag);

        mMenuSceneFragment = new MenuSceneFragment();
        setFragment(mMenuSceneFragment,"MAIN_MENU");

        attachFragment(mMenuSceneFragment);

    }

    public void attachFragment(Fragment fragment){
        FragmentManager fm = getScreen().getGame().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.xml_id,fragment,getTag()).commit();
    }

    public void draw(){
        drawBackground();
        drawForeground();
    }

    private void drawForeground() {
        Canvas c = new Canvas(getForeground());
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        c.drawRect(400,400,600,600,p);
    }

    private void drawBackground() {
        Canvas c = new Canvas(getBackground());
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(45f);
        c.drawText("Loading...",50,50,p);
    }

    public void switchMenu(String tag){
        switch (tag){
            case "MAIN_MENU":
                replaceFragment(new MenuSceneFragment());
                break;
            default:
                remove(getFragment());

        }
    }


}
