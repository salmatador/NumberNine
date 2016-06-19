package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameGraphics {

    
    public GameGraphics(){

    }

    public static Bitmap createBitmap(Point dimensions) {
        Bitmap temp = Bitmap.createBitmap(dimensions.x,dimensions.y, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(temp);
        Paint p = new Paint();
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        c.drawRect(0,0,dimensions.x,dimensions.y,p);
        return temp;
    }
}
