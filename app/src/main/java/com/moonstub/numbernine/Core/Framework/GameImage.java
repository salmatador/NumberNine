package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;

/**
 * Created by mkline on 6/21/2016.
 */
public class GameImage {

    Bitmap mImage = null;
    int mW = 0, mH = 0;

    public GameImage(Bitmap bitmap) {
        mImage = bitmap;
        mW = mImage.getWidth();
        mH = mImage.getHeight();
    }

    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap mImage) {
        this.mImage = mImage;
        setW(mImage.getWidth());
        setH(mImage.getHeight());
    }

    public int getW() {
        return mW;
    }

    public void setW(int mW) {
        this.mW = mW;
    }

    public void setH(int h) {
        mH = h;
    }
}
