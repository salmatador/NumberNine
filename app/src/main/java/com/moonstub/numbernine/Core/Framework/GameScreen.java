package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.util.Log;

import com.moonstub.numbernine.R;

import java.util.HashMap;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameScreen {

    int test = 255;
    int step = -5;

    GameActivity game;
    //HashMap<String, GameFragment> gameUiFragments;
    GameRenderer gameRenderer;
    //GameBoard gameBoard;
    Point screenDimension = new Point();

    public GameScreen(GameActivity gameActivity){
        game = gameActivity;
        setDimensions();
        gameRenderer = new GameRenderer(game, this);
        gameRenderer.start();

        getGame().getSupportFragmentManager().beginTransaction().add(R.id.main_render, new MainGameScene(), "GAME_BOARD").commit();
        //addFragment(new GameFragment(), "menu_main");
        //addFragment(new GameFragment(), "menu_options");
        //addFragment(new GameFragment(), "menu_score");

        //Testing
        getGameRenderer().addBitmap("TEST_MAP", getDimensions(), true);
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

//    public boolean addFragment(GameFragment gameFragment, String tag){
//        // make sure gameUiFragments has be instantiated
//        if(gameUiFragments == null){
//            gameUiFragments = new HashMap<>();
//        }
//        //TODO check if fragment exists before adding
//        gameUiFragments.put(tag, gameFragment);
//        return true;
//    }

    public void draw(){
        Paint p = new Paint();
        //p.setAlpha(25);
        Bitmap b = getGameRenderer().getBitmapByTag("GAME_BACKGROUND");//.getBitmapBackground();
        Canvas bc = new Canvas(b);
        bc.drawARGB(255,0,0,0);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.WHITE);
        bc.drawRect(250,250,750,750,p);

        Bitmap f = getGameRenderer().getBitmapByTag("GAME_FOREGROUND");//.getBitmapForeground();
        Canvas fc = new Canvas(f);
        fc.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        fc.drawARGB(test,0,0,255);

        test = test + step;
        if(test < 1 || test > 254) {
            step = step * -1;
        }

        Bitmap t = getGameRenderer().getBitmapByTag("TEST_MAP");
        Canvas tc = new Canvas(t);
        tc.drawRect(0,0,500,500,p);
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
}
