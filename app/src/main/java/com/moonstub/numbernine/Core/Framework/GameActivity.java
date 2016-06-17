package com.moonstub.numbernine.Core.Framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moonstub.numbernine.R;

public class GameActivity extends AppCompatActivity {

    //Declare Classes

    GameScreen gameScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameScreen = new GameScreen(this);

        //setContentView(gameScreen.getGameRenderer());

       // gameScreen.getGameRenderer().start();


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
}
