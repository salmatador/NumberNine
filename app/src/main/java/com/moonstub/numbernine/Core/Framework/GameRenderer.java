package com.moonstub.numbernine.Core.Framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameRenderer extends SurfaceView implements Runnable {

    GameScreen currentScreen;
    Bitmap background;
    Bitmap foreground;

    SurfaceHolder mHolder;
    Thread mThread;
    boolean isRunning;

    public GameRenderer(GameActivity gameActivity, GameScreen gameScreen) {
        super(gameActivity);
        currentScreen = gameScreen;
        background = GameGraphics.createBitmap(currentScreen.getDimensions());
        foreground = GameGraphics.createBitmap(currentScreen.getDimensions());

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
            c.drawBitmap(background, null, dst, null);
            c.drawBitmap(foreground,null,dst,null);
            mHolder.unlockCanvasAndPost(c);

        }
    }

    public GameScreen getCurrentScreen() {
        return currentScreen;
    }

    public Bitmap getBitmapBackground() {
        return background;
    }

    public Bitmap getBitmapForeground() {
        return foreground;
    }
}
