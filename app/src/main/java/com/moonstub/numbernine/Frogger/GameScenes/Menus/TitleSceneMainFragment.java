package com.moonstub.numbernine.Frogger.GameScenes.Menus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.moonstub.numbernine.Core.Framework.GameFragment;
import com.moonstub.numbernine.Frogger.Constants.SCENES;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/21/2016.
 */
public class TitleSceneMainFragment extends GameFragment {

    Button playButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.title_scene_layout, container, false);

        playButton = (Button)v.findViewById(R.id.title_scene_play_btn);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getGameScreen().switchScene(SCENES.LEVEL_PICKER);
                getGameScreen().sceneNavigation(true);
            }
        });

        return v;
    }
}
