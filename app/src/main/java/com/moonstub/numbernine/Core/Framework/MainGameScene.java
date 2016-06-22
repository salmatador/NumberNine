package com.moonstub.numbernine.Core.Framework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.moonstub.numbernine.R;

/**
 * Created by mkline on 6/17/2016.
 */
public class MainGameScene extends Fragment {

    GameActivity gameActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gameActivity = (GameActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_game, container, false);

        FrameLayout fl = (FrameLayout)rootView.findViewById(R.id.main_render);
              fl.addView(gameActivity.getGameScreen().getGameRenderer());

        return rootView;
    }
}
