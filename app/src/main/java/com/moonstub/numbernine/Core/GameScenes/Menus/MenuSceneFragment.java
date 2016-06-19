package com.moonstub.numbernine.Core.GameScenes.Menus;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.moonstub.numbernine.Core.Framework.GameActivity;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/17/2016.
 */
public class MenuSceneFragment extends GameFragment{

    Button button1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_main,container,false);
        button1 = (Button)v.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = getGameScreen().getCurrentScene().getFragment();
                getGameScreen().getCurrentScene().remove(f);
            }
        });
        return v;
    }


}
