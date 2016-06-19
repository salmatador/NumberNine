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
 * Created by desktop on 6/19/2016.
 */
public class RendererFragment extends Fragment {

    GameActivity mGameActivity;
    GameScreen mGameScreen;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mGameActivity = (GameActivity) context;
        mGameScreen = getGameActivity().getGameScreen();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.renderer_layout, container, false);
        FrameLayout renderFrame = (FrameLayout)v.findViewById(R.id.renderable_layout);
        renderFrame.addView(getGameScreen().getGameRenderer());
        getGameScreen().getGameRenderer().start();
        return v;
    }

    public GameActivity getGameActivity() {
        return mGameActivity;
    }

    public GameScreen getGameScreen() {
        return mGameScreen;
    }
}
