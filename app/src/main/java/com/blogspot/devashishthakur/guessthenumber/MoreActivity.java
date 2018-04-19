package com.blogspot.devashishthakur.guessthenumber;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
    }
    public void goMainMenu(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}
