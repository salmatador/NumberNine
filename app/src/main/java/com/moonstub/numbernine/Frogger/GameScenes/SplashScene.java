package com.moonstub.numbernine.Frogger.GameScenes;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.moonstub.numbernine.Core.Framework.GameImage;
import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneFragment;
import com.moonstub.numbernine.Frogger.GameScenes.Menus.SplashWaitingFragment;

/**
 * Created by mkline on 6/20/2016.
 */
public class SplashScene extends GameScene {

    //Can this be an ENUM
    public static final String WAITING = "waiting";

    GameImage splashImage;

    public SplashScene(GameScreen screen, String tag) {
        super(screen, tag);

        addFragmentToMap(WAITING, new SplashWaitingFragment());
        setFragment(getFragmentByTag(WAITING), WAITING);
    }

    @Override
    public void init() {
        splashImage = getScreen().getGraphics().getGameImage("splash.png");
        attachFragment(getFragmentByTag(WAITING));
    }

    public void update(){

    }

    @Override
    public void drawForeground() {
        Canvas c = new Canvas(getBackground());
        getGraphics().drawScaledImage(c,getScreenDimensions(),splashImage.getImage());

    }

    @Override
    public void drawBackground() {

    }
}
