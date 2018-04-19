package com.blogspot.devashishthakur.guessthenumber;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HelpActivity extends AppCompatActivity {

    AdView mAdview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        MobileAds.initialize(this, "ca-app-pub-5044797211247790~8040546596");
        mAdview1 = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdview1.loadAd(adRequest1);
    }

    //On clicking back button

    public void goMainMenu(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}
