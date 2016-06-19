package com.moonstub.numbernine.Core.Framework;

import android.graphics.Point;

import com.moonstub.numbernine.Core.GameScenes.LoadingScene;
import com.moonstub.numbernine.R;

import java.util.HashMap;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameScreen {

    GameActivity game;
    GameRenderer gameRenderer;

    Point screenDimension = new Point();
    String mCurrentSceneTag = null;

    HashMap<String, GameScene> gameScene;

    GameScene mCurrentScene;

    //HashMap<String, GameFragment> gameUiFragments;
    //TODO Clean Up Code
    //TODO Second Scene

    public GameScreen(GameActivity gameActivity) {
        //Screen setup
        game = gameActivity;
        setDimensions();
        gameRenderer = new GameRenderer(game, this);


        //Scene setup
        addScene(new LoadingScene(this, "LOADING_SCENE"));
        setCurrentSceneTag("LOADING_SCENE");
        setCurrentScene("LOADING_SCENE");

        initRenderScreen();

        //Fragment Setup
        //addFragment(new GameFragment(), "menu_main");
        //addFragment(new GameFragment(), "menu_options");
        //addFragment(new GameFragment(), "menu_score");

        //gameRenderer.start();
    }

    private void initRenderScreen(){
        getGame().getSupportFragmentManager().beginTransaction()
                .add(R.id.renderable_id,new RendererFragment(),"RENDER_FRAGMENT").commit();
    }

    private void addScene(GameScene scene) {
        if(gameScene == null){
            gameScene = new HashMap<>();
        }

        gameScene.put(scene.getTag(),scene);
    }

    public void setDimensions(){
        getGame().getWindowManager().getDefaultDisplay().getRealSize(screenDimension);
        //Log.d("Screen Size", screenDimension.toString());
    }

    public void switchFragment(String tag) {
        switch (tag) {
            case Tags.MENU_MAIN:
                break;
            case Tags.MENU_OPTIONS:
                break;
            case Tags.MENU_SCORE:

            default:
                break;
        }
    }

    public void draw(){
        if(gameScene != null && getCurrentSceneTag() != null) {
            gameScene.get(mCurrentSceneTag).draw();
        }
    }

    public void update(){
        if(gameScene != null && getCurrentSceneTag() != null) {
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


    public GameScene getCurrentScene(){
        return mCurrentScene;
    }
    public void setCurrentScene(String currentScene) {
        mCurrentScene = gameScene.get(currentScene);
    }
}
