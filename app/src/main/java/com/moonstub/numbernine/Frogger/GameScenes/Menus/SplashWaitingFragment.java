package com.moonstub.numbernine.Frogger.GameScenes.Menus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.moonstub.numbernine.Core.Framework.GameFragment;
import com.moonstub.numbernine.R;

/**
 * Created by mkline on 6/21/2016.
 */
public class SplashWaitingFragment extends GameFragment {

    ProgressBar mSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.splash_waiting_fragment, container, false);

        mSpinner = (ProgressBar)rootView.findViewById(R.id.splash_waiting_spinner);

        //Start an AsyncTask and when done load next Scene

        mSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSpinner.setVisibility(View.GONE);
            }
        });

        return rootView;
    }
}
