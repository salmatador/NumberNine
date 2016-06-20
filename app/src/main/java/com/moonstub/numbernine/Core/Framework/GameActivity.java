package com.moonstub.numbernine.Core.Framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moonstub.numbernine.Frogger.FrogScreen;
import com.moonstub.numbernine.R;

public class GameActivity extends AppCompatActivity {

    //Declare Classes

    GameScreen gameScreen;
    GameSound gameSound;
    GameIO gameIO;
    GameInput gameInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameScreen = new FrogScreen(this);
        gameIO = new GameIO(this);
        gameInput = new GameInput(this);

    }

    @Override
    protected void onPause() {
        getGameScreen().getGameRenderer().stop();
        super.onPause();

    }

    @Override
    protected void onResume() {
        getGameScreen().getGameRenderer().start();
        super.onResume();
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    @Override
    public void onBackPressed() {
        if(getGameScreen().onBackPressed()) {
            super.onBackPressed();
        }
    }


}
