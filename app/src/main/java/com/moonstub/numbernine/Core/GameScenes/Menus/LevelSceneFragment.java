package com.moonstub.numbernine.Core.GameScenes.Menus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moonstub.numbernine.Core.Framework.GameFragment;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/19/2016.
 */
public class LevelSceneFragment extends GameFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.level_picker_scene, container, false);

        return root;
    }
}
