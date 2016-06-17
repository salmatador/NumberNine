package com.moonstub.numbernine.Core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.moonstub.numbernine.Core.Framework.GameFragment;
import com.moonstub.numbernine.R;

/**
 * Created by mkline on 6/17/2016.
 */
public class GameBoardFragment extends GameFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_game, container, false);
        FrameLayout layout = (FrameLayout)root.findViewById(R.id.background_ui);

        layout.addView(getGameScreen().getGameRenderer());

        return root;
    }
}
