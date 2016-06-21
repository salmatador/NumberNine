package com.moonstub.numbernine.Core.Framework;

import android.graphics.Point;

import com.moonstub.numbernine.Core.GameScenes.GameLevelScene;
import com.moonstub.numbernine.Core.GameScenes.LevelPickerScene;
import com.moonstub.numbernine.Core.GameScenes.LoadingScene;
import com.moonstub.numbernine.Core.GameScenes.MainMenuScene;
import com.moonstub.numbernine.R;

import java.util.HashMap;

/**
 * Created by mkline on 6/16/2016.
 */
public abstract class GameScreen {

    GameActivity game;
    GameRenderer gameRenderer;

    Point screenDimension = new Point();
    String mCurrentSceneTag = null;

    HashMap<String, GameScene> gameScene;

    GameScene mCurrentScene;
    private GameGraphics mGraphics;

    //TODO Clean Up Code

    public GameScreen(GameActivity gameActivity) {
        //Screen setup
        game = gameActivity;
        mGraphics = game.getGameGraphics();
        setDimensions();
        gameRenderer = new GameRenderer(game, this);

        init();

        initRenderScreen();

        getCurrentScene().init();
    }

    public void setCurrentSceneAndTag(String tag){
        setCurrentSceneTag(tag);
        setCurrentScene(tag);
    }

    //Override this method
    public abstract void init();

    private void initRenderScreen() {
        getGame().getSupportFragmentManager().beginTransaction()
                .add(R.id.renderable_id, new RendererFragment(), "RENDER_FRAGMENT").commit();
    }

    protected void addScene(GameScene scene) {
        if (gameScene == null) {
            gameScene = new HashMap<>();
        }

        gameScene.put(scene.getTag(), scene);
    }

    public void setDimensions() {
        getGame().getWindowManager().getDefaultDisplay().getRealSize(screenDimension);
    }

    public Point getScreenDimension() {
        return screenDimension;
    }

    public void draw() {
        if (gameScene != null && getCurrentSceneTag() != null) {
            gameScene.get(mCurrentSceneTag).draw();
        }
    }

    public void update() {
        if (gameScene != null && getCurrentSceneTag() != null) {
            gameScene.get(mCurrentSceneTag).update();
        }
    }

    public GameActivity getGame() {
        return game;
    }

    public Point getDimensions() {
        return screenDimension;
    }

    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    public String getCurrentSceneTag() {
        return mCurrentSceneTag;
    }

    public void setCurrentSceneTag(String currentSceneTag) {
        this.mCurrentSceneTag = currentSceneTag;
    }


    public GameScene getCurrentScene() {
        return mCurrentScene;
    }

    public void setCurrentScene(String currentScene) {
        mCurrentScene = gameScene.get(currentScene);
    }

    public void switchScene(String tag){
        if(tag != null) {
            String s = getCurrentSceneTag();
            gameRenderer.stop();
            setCurrentScene(tag);
            setCurrentSceneTag(tag);
            getCurrentScene().init();

            getGameRenderer().removeBitmap(s + "_FG");
            getGameRenderer().removeBitmap(s + "_BG");
            getGameRenderer().resetCanvas();
            getGameRenderer().start();

        }

    }

    public abstract boolean sceneNavigation(boolean foreward);

    //Redo this without hardCoded Strings
    public boolean onBackPressed() {
        return sceneNavigation(false);
//        switch (getCurrentSceneTag()){
//
//            case "LOADING_SCENE":
//                switchScene("MAIN_MENU");
//                return false;
//            case "MAIN_MENU":
//                switchScene("LEVEL_PICKER");
//                return false;
//            case "LEVEL_PICKER":
//                switchScene("GAME_LEVEL");
//                return false;
//            case "GAME_LEVEL":
//                switchScene("MAIN_MENU");
//                return false;
//            default:
//             return true;
//        }
    }

    public GameGraphics getGraphics() {
        return mGraphics;
    }
}
