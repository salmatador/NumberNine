package com.moonstub.numbernine.Core.GameScenes.Menus;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.moonstub.numbernine.Core.Framework.GameActivity;
import com.moonstub.numbernine.Core.Framework.GameScreen;
import com.moonstub.numbernine.R;

/**
 * Created by desktop on 6/19/2016.
 */
public class GameFragment extends Fragment{

    GameActivity mGameActivity;
    GameScreen mGameScreen;
    //TODO Create generic menus with move able Items
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mGameActivity = (GameActivity) context;
        mGameScreen = mGameActivity.getGameScreen();

    }

    public GameScreen getGameScreen() {
        return mGameScreen;
    }

    public GameActivity getGameActivity() {
        return mGameActivity;
    }

    public void replaceFragment(String tag){
        getGameActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.xml_id,this,tag).commit();
    }
}
