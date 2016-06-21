package com.moonstub.numbernine.Core.Framework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameGraphics {

    //Should this be a singleton

    GameActivity mGameActivity;
    Canvas mCanvas;

    public GameGraphics(GameActivity gameActivity){
        mGameActivity = gameActivity;
    }

    public static Bitmap createBitmap(Point dimensions) {
        Bitmap temp = Bitmap.createBitmap(dimensions.x,dimensions.y, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(temp);
        Paint p = new Paint();
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        c.drawRect(0,0,dimensions.x,dimensions.y,p);
        return temp;
    }

    public void drawScaledImage(Canvas c, Point p, Bitmap b){
        c.drawBitmap(b, new Rect(0,0,b.getWidth(),b.getHeight()),new Rect(0,0,p.x,p.y),new Paint());
    }

    public GameImage getGameImage(String s){
        return new GameImage(loadImage(s));
    }

    public Bitmap loadImage(String s){
        AssetManager assetManager = getGame().getAssets();
        InputStream inputStream = null;
        Bitmap temp = null;

        try {
            inputStream = assetManager.open(s);
            temp = BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                    inputStream = null;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return temp;
    }

    public GameActivity getGame(){
        return mGameActivity;
    }

}
