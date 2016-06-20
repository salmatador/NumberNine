package com.moonstub.numbernine.Core.Framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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


    HashMap<String, Bitmap> mBitmapRenderMap;
    ArrayList<String> drawList;
    //Bitmap background;
    //Bitmap foreground;

    SurfaceHolder mHolder;
    Thread mThread;
    boolean isRunning;

    public GameRenderer(GameActivity gameActivity, GameScreen gameScreen) {
        super(gameActivity);
        currentScreen = gameScreen;

        mBitmapRenderMap = new HashMap<>();
        drawList = new ArrayList<>();
        mHolder = getHolder();
    }

    public void start(){
        isRunning = true;
        mThread = new Thread(this);
        mThread.start();
        Log.d("Called","Start");
    }

//    public void pause(){
//        isRunning = false;
//    }

    public void stop(){
        isRunning = false;
        try {
            mThread.join();
        } catch (InterruptedException e) {

        }
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
            c.drawColor(Color.BLACK);
            for(String tag : drawList ){
                c.drawBitmap(mBitmapRenderMap.get(tag), null, dst, null);
            }

            mHolder.unlockCanvasAndPost(c);

        }
    }

    public GameScreen getCurrentScreen() {
        return currentScreen;
    }

    public Bitmap addBitmapToRender(String tag, boolean addToDrawList){
        if(mBitmapRenderMap == null){
            mBitmapRenderMap = new HashMap<>();
        }
        mBitmapRenderMap.put(tag, GameGraphics.createBitmap(getCurrentScreen().getDimensions()));
        if(addToDrawList){
            drawList.add(tag);
        }
        return mBitmapRenderMap.get(tag);
    }

    public void removeBitmap(String tag){
        mBitmapRenderMap.remove(tag);
        drawList.remove(tag);
    }

    public void resetCanvas() {

    }
}
