package com.moonstub.numbernine.Core.GameScenes.Menus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/19/2016.
 */
public class MenuSceneSubFragment extends GameFragment {

    String[] TAGS = new String[]{"MAIN_MENU","MENU_OPTIONS","NULL"};

    Button button1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_main_1,container,false);
        button1 = (Button)v.findViewById(R.id.menu_options_btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceCurrentMenu(TAGS[0]);
            }
        });
        return v;
    }


}
