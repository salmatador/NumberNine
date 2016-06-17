package com.moonstub.numbernine.Core.Framework;

import android.content.ContentProvider;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameRendererUi extends SurfaceView implements Runnable {

    GameScreen currentScreen;
    Bitmap background;
    Bitmap foreground;

    SurfaceHolder mHolder;
    Thread mThread;
    boolean isRunning;

    public GameRendererUi(GameActivity gameActivity, GameScreen gameScreen) {
        super(gameActivity);
        currentScreen = gameScreen;
        background = GameGraphics.createBitmap(currentScreen.getDimensions());
        foreground = GameGraphics.createBitmap(currentScreen.getDimensions());

        mHolder = getHolder();
        mHolder.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);
    }

    public void start(){
        if(isRunning != true) {
            isRunning = true;
            mThread = new Thread(this);
            mThread.start();
        }
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

            if(getCurrentFragmentScreen() != null) {
                getCurrentFragmentScreen().update();
                getCurrentFragmentScreen().draw();
            }


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

    public GameFragment getCurrentFragmentScreen() {
        return getCurrentScreen().getCurrentFragment();
    }
}
