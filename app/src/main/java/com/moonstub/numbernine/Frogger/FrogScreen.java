package com.moonstub.numbernine.Frogger;

import com.moonstub.numbernine.Core.Framework.GameActivity;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.GameScenes.GameLevelScene;
import com.moonstub.numbernine.Frogger.Constants.SCENES;
import com.moonstub.numbernine.Frogger.GameScenes.LevelPickerScene;
import com.moonstub.numbernine.Frogger.GameScenes.SplashScene;
import com.moonstub.numbernine.Frogger.GameScenes.TitleScene;

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
        addScene(new TitleScene(this, SCENES.TITLE));
        //addScene(new LoadingScene(this, SCENES.LOADING));
        //addScene(new MainMenuScene(this, SCENES.MAIN_MENU));
        addScene(new LevelPickerScene(this, SCENES.LEVEL_PICKER));
        addScene(new GameLevelScene(this, SCENES.GAME_LEVEL));

        setCurrentSceneAndTag(SCENES.SPLASH);

    }

    @Override
    public boolean sceneNavigation(boolean foreward) {
        switch (getCurrentSceneTag()) {
            case SCENES.SPLASH:
                if (foreward) {
                    switchScene(SCENES.TITLE);
                    return false;
                }
                return true;
            case SCENES.TITLE:
                if (foreward) {
                    switchScene(SCENES.LEVEL_PICKER);
                    return false;
                }
                return true;
            case SCENES.LEVEL_PICKER:
                if (foreward) {
                    return false;
                }
                switchScene(SCENES.TITLE);
                return false;
            case SCENES.GAME_LEVEL:
                default:
                return true;
        }
    }
}
