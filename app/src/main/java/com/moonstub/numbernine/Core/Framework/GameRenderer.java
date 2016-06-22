package com.moonstub.numbernine.Core.Framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameRenderer extends SurfaceView implements Runnable {

    GameScreen currentScreen;
    Bitmap background;
    Bitmap foreground;
    HashMap<String, Bitmap> renderableBitmaps;
    ArrayList<String> drawList = new ArrayList<>();


    SurfaceHolder mHolder;
    Thread mThread;
    boolean isRunning;

    public GameRenderer(GameActivity gameActivity, GameScreen gameScreen) {
        super(gameActivity);
        currentScreen = gameScreen;
        renderableBitmaps = new HashMap<>();
        renderableBitmaps.put("GAME_BACKGROUND", GameGraphics.createBitmap(currentScreen.getDimensions()));
        renderableBitmaps.put("GAME_FOREGROUND", GameGraphics.createBitmap(currentScreen.getDimensions()));

        drawList.add("GAME_BACKGROUND");
        drawList.add("GAME_FOREGROUND");

        //background = GameGraphics.createBitmap(currentScreen.getDimensions());
        //foreground = GameGraphics.createBitmap(currentScreen.getDimensions());

        mHolder = getHolder();
    }

    public void start(){
        isRunning = true;
        mThread = new Thread(this);
        mThread.start();
    }

    public void stop(){
        isRunning = false;
        try {
            mThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void addBitmap(String tag, Point dimension, boolean addToDrawList){
        renderableBitmaps.put(tag, GameGraphics.createBitmap(dimension));
        if(addToDrawList){
            addToDrawList(tag);
        }
    }

    private void addToDrawList(String tag) {
        drawList.add(tag);
    }

    public void removeTagFromDrawList(String tag){
        drawList.remove(tag);
    }

    @Override
    public void run() {

        Rect dst = new Rect();
        Thread currentThread = Thread.currentThread();
        //Setup Timer

        while (isRunning && mThread == currentThread) {
            if (!mHolder.getSurface().isValid()) {
                continue;
            }

            //update
            getCurrentScreen().update();
            //draw
            getCurrentScreen().draw();


            Canvas c = mHolder.lockCanvas();
            c.getClipBounds(dst);
            //Log.d("Test","123");
            for (String tag : drawList){
                c.drawBitmap(renderableBitmaps.get(tag),null,dst,null);
                Log.d("Drawing", "Current Bitmap " + tag);
            }
            //c.drawBitmap(background, null, dst, null);
            //c.drawBitmap(foreground,null,dst,null);
            mHolder.unlockCanvasAndPost(c);

        }
    }

    public GameScreen getCurrentScreen() {
        return currentScreen;
    }

    public Bitmap getBitmapByTag(String tag){
        return renderableBitmaps.get(tag);
    }

    public Bitmap getBitmapBackground() {
        return background;
    }

    public Bitmap getBitmapForeground() {
        return foreground;
    }
}
