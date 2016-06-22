package com.moonstub.numbernine.Frogger.GameScenes;

import com.moonstub.numbernine.Core.Framework.GameScene;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Frogger.Constants.SCENES;
import com.moonstub.numbernine.Frogger.GameScenes.Menus.TitleSceneMainFragment;

/**
 * Created by desktop on 6/21/2016.
 */
public class TitleScene extends GameScene {


    public TitleScene(GameScreen screen, String tag) {
        super(screen, tag);

        addFragmentToMap(SCENES.TITLE_MAIN_MENU, new TitleSceneMainFragment());

        setCurrentFragment(SCENES.TITLE_MAIN_MENU);
    }

    @Override
    public void init() {
        if(getFragment() != null) {
            attachFragment(getFragment());
        }
    }

    @Override
    public void drawForeground() {

    }

    @Override
    public void drawBackground() {

    }
}
