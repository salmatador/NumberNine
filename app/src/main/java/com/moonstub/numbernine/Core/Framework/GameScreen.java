package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.nfc.Tag;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.moonstub.numbernine.Core.GameBoardFragment;
import com.moonstub.numbernine.Core.MainMenuFragment;
import com.moonstub.numbernine.R;

import java.util.HashMap;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameScreen {

    int test = 255;
    int step = -1;

    GameActivity game;
    HashMap<String, GameFragment> gameUiFragments;
    GameRenderer gameRenderer;
    GameRendererUi gameRendererUi;

    String currentTag;
    //GameBoard gameBoard;
    Point screenDimension = new Point();
    GameFragment currentFragment;

    public GameScreen(GameActivity gameActivity){
        game = gameActivity;
        setDimensions();
        gameRenderer = new GameRenderer(game, this);
        gameRendererUi = new GameRendererUi(game, this);
        gameRenderer.start();
        currentTag = Tags.MENU_MAIN;
        gameRendererUi.start();

        addFragment(new GameBoardFragment(), Tags.GAME_SCREEN);
        addFragment(new MainMenuFragment(), Tags.MENU_MAIN);
        addFragment(new GameFragment(), Tags.MENU_OPTIONS);
        addFragment(new GameFragment(), Tags.MENU_SCORE);


        attachFragment(getFragmentId(Tags.GAME_SCREEN), Tags.GAME_SCREEN, R.id.background_ui);
        attachFragment(getFragmentId(Tags.MENU_MAIN), Tags.MENU_MAIN, R.id.foreground_ui);

    }

    public void setDimensions(){
        getGame().getWindowManager().getDefaultDisplay().getRealSize(screenDimension);
        //Log.d("Screen Size", screenDimension.toString());
    }

    public void removeFragment(String tag){
        FragmentTransaction ft = getGame().getSupportFragmentManager().beginTransaction();
        //ft.remove(gameUiFragments.get(tag));
        ft.remove(gameUiFragments.get(tag)).commit();
    }

    public void attachFragment(int id,String tag, int layout){
        FragmentTransaction ft = getGame().getSupportFragmentManager().beginTransaction();
        ft.add(layout, gameUiFragments.get(tag)).commit();
    }

    public int getFragmentId(String tag) {
        switch (tag) {
            case Tags.MENU_MAIN:
                return R.id.main_menu;
            case Tags.MENU_OPTIONS:
                return R.id.options_menu;
            case Tags.MENU_SCORE:
                return R.id.score_menu;
            default:
                return R.id.background_root;
        }
    }

    public boolean addFragment(GameFragment gameFragment, String tag){
        // make sure gameUiFragments has be instantiated
        if(gameUiFragments == null){
            gameUiFragments = new HashMap<>();
        }
        //TODO check if fragment exists before adding
        gameUiFragments.put(tag, gameFragment);
        return true;
    }

    public void draw(){
        Paint p = new Paint();
        p.setAlpha(25);
        Bitmap b = getGameRenderer().getBitmapBackground();
        Canvas bc = new Canvas(b);
        bc.drawARGB(255,0,0,0);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.WHITE);
        bc.drawRect(0,0,500,500,p);

        Bitmap f = getGameRenderer().getBitmapForeground();
        Canvas fc = new Canvas(f);
        fc.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        fc.drawARGB(test,0,0,255);

        test = test + step;
        if(test < 1 || test > 254) {
            step = step * -1;
        }
    }
    public void update(){}

    public GameActivity getGame() {
        return game;
    }

    public Point getDimensions() {
        return screenDimension;
    }

    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    public GameRendererUi getUiRenderer() {
        return gameRendererUi;
    }

    public GameFragment getFragmentByTag(String tag){
        return gameUiFragments.get(tag);
    }

    public GameFragment getCurrentFragment() {
        return gameUiFragments.get(currentTag);
    }

    public String getCurrentTag() {
        return currentTag;
    }

    public void setCurrentTag(String currentTag) {
        this.currentTag = currentTag;
    }
}
