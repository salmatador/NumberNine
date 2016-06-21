package com.moonstub.numbernine.Core.GameScenes.Menus;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.moonstub.numbernine.Core.Framework.GameFragment;
import com.moonstub.numbernine.Frogger.GameScenes.SplashScene;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/17/2016.
 */
public class MenuSceneFragment extends GameFragment {
    String[] TAGS = new String[]{"MAIN_MENU", "MENU_OPTIONS", "MENU_SCORE", "NULL"};
    Button mOptionsBtn;
    ImageButton mPlayBtn;
    Button mScoreBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_main, container, false);

        mOptionsBtn = (Button) v.findViewById(R.id.menu_options_btn);
        mPlayBtn = (ImageButton) v.findViewById(R.id.menu_play_btn);
        mScoreBtn = (Button) v.findViewById(R.id.menu_score_btn);

        mOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceCurrentMenu(TAGS[1]);
            }
        });
        mPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceCurrentMenu(TAGS[3]);
            }
        });
        mScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceCurrentMenu(TAGS[2]);
            }
        });
        return v;
    }


}
