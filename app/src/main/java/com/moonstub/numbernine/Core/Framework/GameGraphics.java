package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by mkline on 6/16/2016.
 */
public class GameGraphics {

    
    public GameGraphics(){

    }

    public static Bitmap createBitmap(Point dimensions) {
        return Bitmap.createBitmap(dimensions.x,dimensions.y, Bitmap.Config.ARGB_4444);
    }
}
