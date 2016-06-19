package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/19/2016.
 */
public class GameScene {

    GameScreen mScreen;
    String mTag;

    Fragment mFragment;
    Bitmap mBackground;
    Bitmap mForeground;
    String mFragmentTag;

    public GameScene(GameScreen screen, String tag) {
        mScreen = screen;
        mTag = tag;
        mBackground = createBitmap(getTag() + "_BG", true);
        mForeground = createBitmap(getTag() + "_FG", true);
    }

    private Bitmap createBitmap(String s, boolean add) {
        return mScreen.getGameRenderer().addBitmapToRender(s, add);
    }

    public String getTag() {
        return mTag;
    }

    public void update() {

    }

    public void draw() {
        Canvas b = new Canvas(mBackground);
        Paint bp = new Paint();
        bp.setColor(Color.WHITE);
        bp.setStyle(Paint.Style.FILL);
        b.drawRect(100, 100, 400, 400, bp);

        Canvas f = new Canvas(mForeground);
        Paint fp = new Paint();
        fp.setColor(Color.WHITE);
        fp.setStyle(Paint.Style.FILL);
        f.drawRect(200, 200, 500, 500, fp);
    }

    public Bitmap getBackground() {
        return mBackground;
    }

    public Bitmap getForeground() {
        return mForeground;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment, String tag) {
        mFragmentTag = tag;
        mFragment = fragment;
    }

    public String getFragmentTag() {
        return mFragmentTag;
    }

    public GameScreen getScreen() {
        return mScreen;
    }

    public void remove(Fragment fragment) {
        FragmentManager fm = getScreen().getGame().getSupportFragmentManager();
        fm.beginTransaction().remove(fragment).commit();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getScreen().getGame().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.xml_id,fragment,getTag()).commit();
    }
}
