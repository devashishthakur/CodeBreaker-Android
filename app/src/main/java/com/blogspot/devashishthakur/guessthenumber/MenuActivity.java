package com.blogspot.devashishthakur.guessthenumber;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
public class MenuActivity extends AppCompatActivity {

    AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        MobileAds.initialize(this, "ca-app-pub-5044797211247790~8040546596");

        mAdview = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

    }
    //On clicking play button
    public void jumpToOther(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Button play = (Button) findViewById(R.id.playB);
        Button easy = (Button) findViewById(R.id.easyB);
        Button med = (Button)  findViewById(R.id.medB);
        Button hard = (Button) findViewById(R.id.hardB);
        play.setVisibility(View.INVISIBLE);
        easy.setVisibility(View.VISIBLE);
        med.setVisibility(View.VISIBLE);
        hard.setVisibility(View.VISIBLE);
    }

    //On clicking help button

    public void jumpToHelp(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,HelpActivity.class);
        startActivity(intent);
    }
    public void jumpToAbout(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,MoreActivity.class);
        startActivity(intent);
    }
    public void jumpToExit(View view)
    {

        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    public void onEasyCLick(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,GuessActivity.class);
        intent.putExtra("GuessValue",5);
        startActivity(intent);
    }
    public void onMedCLick(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,GuessActivity.class);
        intent.putExtra("GuessValue",4);
        startActivity(intent);
    }
    public void onHardCLick(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,GuessActivity.class);
        intent.putExtra("GuessValue",3);
        startActivity(intent);
    }


}
