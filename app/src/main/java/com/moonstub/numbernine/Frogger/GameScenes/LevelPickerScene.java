package com.moonstub.numbernine.Frogger.GameScenes;

import android.app.DialogFragment;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Frogger.GameScenes.Menus.LevelSceneFragment;
import com.moonstub.numbernine.Frogger.Constants.SCENES;

/**
 * Created by desktop on 6/19/2016.
 */
public class LevelPickerScene extends GameScene {


    private DialogFragment mDialogFragment;

    public LevelPickerScene(GameScreen screen, String tag) {
        super(screen, tag);

        //Load Menu Fragments
        addFragmentToMap(SCENES.LEVEL_PICKER_MAIN, new LevelSceneFragment());

        //SET FIRST FRAGMENT OF SCENE
        setCurrentFragment(SCENES.LEVEL_PICKER_MAIN);

    }

    @Override
    public void init() {
        attachFragment(getFragment());
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

    @Override
    public boolean onBackPressed() {
        if (getDialogFragment() == null) {
            return super.onBackPressed();
        } else {
            attachDialogFragment(getDialogFragment());
        }
        return true;
    }

    private void attachDialogFragment(DialogFragment dialogFragment) {
        //Dialog popup for backpress
    }

    public DialogFragment getDialogFragment() {
        return mDialogFragment;
    }
}
