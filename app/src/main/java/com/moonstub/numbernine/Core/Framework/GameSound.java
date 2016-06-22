package com.moonstub.numbernine.Core.Framework;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;

/**
 * Created by mkline on 6/20/2016.
 */
public class GameSound {

    SoundPool mSoundPool;

    public GameSound(){
        if(mSoundPool == null){
            createPool();
        }
    }

    private void createPool() {

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private AudioAttributes poolAttrbs(){
        return new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

    }

    //private SoundPool


}
