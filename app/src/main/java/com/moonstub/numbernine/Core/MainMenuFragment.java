package com.moonstub.numbernine.Core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.moonstub.numbernine.Core.Framework.GameActivity;
import com.moonstub.numbernine.Core.Framework.GameFragment;
import com.moonstub.numbernine.Core.Framework.GameRendererUi;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.Core.Framework.Tags;
import com.moonstub.numbernine.R;

/**
 * Created by mkline on 6/17/2016.
 */
public class MainMenuFragment extends GameFragment {


    GameActivity gameActivity;
    GameScreen gameScreen;
    //GameRendererUi gameRendererUi;
    Button testBtn;
    FrameLayout fl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.menu_main_layout, container, false);
        fl = (FrameLayout) root.findViewById(R.id.ui_surface);
        fl.addView(getFragmentRenderer());
        testBtn = (Button)root.findViewById(R.id.menu_main_test_btn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentRenderer().stop();
                fl.removeView(getFragmentRenderer());

                getGameScreen().removeFragment(getGameScreen().getCurrentTag());
                getGameScreen().setCurrentTag(Tags.MENU_OPTIONS);
                getGameScreen().attachFragment(getGameScreen().getFragmentId(Tags.MENU_OPTIONS), Tags.MENU_OPTIONS, R.id.foreground_ui);

            }
        });


        getFragmentRenderer().start();
        return root;
    }

    public void update(){}

    public void draw(){
        if(getFragmentRenderer() != null){
            Log.d("Main Menu UI Render","NOT NULL");
        } else {
            Log.d("Main Menu UI Render", "IS STILL NULL");
        }
//        if(getFragmentRenderer() != null) {
            Bitmap b = getGameScreen().getUiRenderer().getBitmapForeground();
            Canvas bc = new Canvas(b);

            Paint p = new Paint();
            p.setColor(Color.RED);
            p.setStrokeWidth(15f);
            bc.drawRect(0, 0, 100, 300, p);
//        }
//        Paint p = new Paint();
//        //p.setAlpha(25);
//        Bitmap b = getGameScreen().getUiRenderer().getBitmapBackground();
//        Canvas bc = new Canvas(b);
//        //bc.drawARGB(255,0,0,0);
//        p.setStyle(Paint.Style.FILL);
//        p.setColor(Color.CYAN);
//        bc.drawRect(300,200,500,500,p);
//
//        Bitmap f = getGameScreen().getUiRenderer().getBitmapForeground();
//        Canvas fc = new Canvas(f);
//        fc.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
//
//        fc.drawARGB(0,0,0,0);
//
//
//        Log.d("Draw Called",gameRendererUi.getBitmapBackground().getWidth() + " , " + gameRendererUi.getBitmapBackground().getHeight());
//        test = test + step;
//        if(test < 1 || test > 254) {
//            step = step * -1;
//        }

    }



}
