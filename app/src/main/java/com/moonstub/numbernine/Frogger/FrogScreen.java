package com.moonstub.numbernine.Frogger;

import com.moonstub.numbernine.Core.Framework.GameActivity;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.GameScenes.GameLevelScene;
import com.moonstub.numbernine.Core.GameScenes.LevelPickerScene;
import com.moonstub.numbernine.Core.GameScenes.LoadingScene;
import com.moonstub.numbernine.Core.GameScenes.MainMenuScene;
import com.moonstub.numbernine.Core.constants.SCENE;
import com.moonstub.numbernine.Frogger.Constants.SCENES;
import com.moonstub.numbernine.Frogger.GameScenes.SplashScene;

/**
 * Created by mkline on 6/20/2016.
 */
public class FrogScreen extends GameScreen {


    public FrogScreen(GameActivity gameActivity) {
        super(gameActivity);
    }

    @Override
    public void init() {
        //Scene setup
        addScene(new SplashScene(this, SCENES.SPLASH));
        addScene(new LoadingScene(this, SCENES.LOADING));
        addScene(new MainMenuScene(this, SCENES.MAIN_MENU));
        addScene(new LevelPickerScene(this, SCENES.LEVEL_PICKER));
        addScene(new GameLevelScene(this, SCENES.GAME_LEVEL));

        setCurrentSceneAndTag(SCENES.SPLASH);

    }

    @Override
    public boolean sceneNavigation(boolean foreward) {
        switch (getCurrentSceneTag()) {
            case SCENES.SPLASH:
                if (foreward) {
                    switchScene(SCENES.MAIN_MENU);
                    return false;
                } else {
                    return true;
                }
            case SCENES.MAIN_MENU:
                return false;
            case SCENES.LEVEL_PICKER:
                return false;
            case SCENES.GAME_LEVEL:
                return false;
            default:
                return true;
        }
    }
}
