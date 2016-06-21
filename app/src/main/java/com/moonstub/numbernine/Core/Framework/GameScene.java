package com.moonstub.numbernine.Core.Framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.moonstub.numbernine.Core.GameScenes.Menus.MenuSceneFragment;
import com.moonstub.numbernine.R;

import java.util.HashMap;

/**
 * Created by desktop on 6/19/2016.
 */
public abstract class GameScene {

    GameScreen mScreen;
    String mTag;

    Point screenDimensions;
    GameGraphics mGraphics;

    Fragment mFragment;
    Bitmap mBackground;
    Bitmap mForeground;
    String mFragmentTag;

    HashMap<String,Fragment> mFragmentMap;

    public GameScene(GameScreen screen, String tag, boolean add) {
        mScreen = screen;
        mTag = tag;
        mBackground = createBitmap(getTag() + "_BG", add);
        mForeground = createBitmap(getTag() + "_FG", add);

        mFragmentMap = new HashMap<>();

        screenDimensions = getScreen().getDimensions();
        mGraphics = getScreen().getGraphics();


    }
    public GameScene(GameScreen screen, String tag) {
        mScreen = screen;
        mTag = tag;
        mBackground = createBitmap(getTag() + "_BG", true);
        mForeground = createBitmap(getTag() + "_FG", true);

        mFragmentMap = new HashMap<>();

        screenDimensions = getScreen().getDimensions();
        mGraphics = getScreen().getGraphics();

    }

    public abstract void init();


    public void attachFragment(Fragment fragment){
        FragmentManager fm = getScreen().getGame().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.xml_id,fragment,getTag()).commit();
    }

    private Bitmap createBitmap(String s, boolean add) {
        return mScreen.getGameRenderer().addBitmapToRender(s, add);
    }

    public String getTag() {
        return mTag;
    }

    public void update() {

    }

//    public void draw() {
//        Canvas b = new Canvas(mBackground);
//        Paint bp = new Paint();
//        bp.setColor(Color.WHITE);
//        bp.setStyle(Paint.Style.FILL);
//        b.drawRect(100, 100, 400, 400, bp);
//
//        Canvas f = new Canvas(mForeground);
//        Paint fp = new Paint();
//        fp.setColor(Color.WHITE);
//        fp.setStyle(Paint.Style.FILL);
//        f.drawRect(200, 200, 500, 500, fp);
//    }

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
        if(fragment != null){
            remove(fragment);
        }
        mFragmentTag = tag;
        mFragment = fragment;
    }

    public void addFragmentToMap(String s, Fragment f){
        mFragmentMap.put(s,f);
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

    //TODO Implement
    public void switchMenu(String tag){
        switch (tag){
            case "MAIN_MENU":
                replaceFragment(new MenuSceneFragment());
                break;
            default:
                remove(getFragment());

        }
    }

    public GameGraphics getGraphics() {
        return mGraphics;
    }

    public Point getScreenDimensions() {
        return screenDimensions;
    }

    public void setScreenDimensions(Point screenDimensions) {
        this.screenDimensions = screenDimensions;
    }

    public Fragment getFragmentByTag(String tag) {
        //TODO Error Check needed
        return mFragmentMap.get(tag);
    }

    public void draw(){
        drawBackground();
        drawForeground();
    }

    public abstract void drawForeground();
//
//        Canvas c = new Canvas(getForeground());
//        Paint p = new Paint();
//        p.setColor(Color.RED);
//        p.setStyle(Paint.Style.FILL);
//        c.drawRect(400,400,600,600,p);
//    }

    public abstract void drawBackground();
//    {
//        Canvas c = new Canvas(getBackground());
//        Paint p = new Paint();
//        p.setColor(Color.WHITE);
//        p.setTextSize(45f);
//        c.drawText("Loading...",50,50,p);
//    }
}
