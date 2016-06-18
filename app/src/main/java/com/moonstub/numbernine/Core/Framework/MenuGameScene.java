package com.moonstub.numbernine.Core.Framework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/17/2016.
 */
public class MenuGameScene extends Fragment{


    GameActivity gameActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //gameActivity = (GameActivity) context;
    }

}
