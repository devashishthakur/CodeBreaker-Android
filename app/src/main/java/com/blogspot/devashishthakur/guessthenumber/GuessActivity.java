package com.blogspot.devashishthakur.guessthenumber;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.preference.PreferenceManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class GuessActivity extends AppCompatActivity {

    private NumberCheck numCheck = new NumberCheck(); // Creating object of NumberCheck class
    // Total Guess
    MediaPlayer music;   // Declaring Mediaplayer

    int totalGuess = 5;

EditText num1;

    private InterstitialAd interstitialAd;
    private InterstitialAd interstitialAd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5044797211247790/4212627004");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd1 = new InterstitialAd(this);
        interstitialAd1.setAdUnitId("ca-app-pub-5044797211247790/4212627004");
        interstitialAd1.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Intent mIntent = getIntent();
                finish();
                startActivity(mIntent);
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        interstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                MediaPlayer mp = MediaPlayer.create(GuessActivity.this,R.raw.clicksound);
                mp.start();
                music.stop();
                Intent intent = new Intent(GuessActivity.this ,MenuActivity.class);
                startActivity(intent);
                interstitialAd1.loadAd(new AdRequest.Builder().build());
            }
        });


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {
            Intent intent = new Intent(this,HelpActivity.class);
            startActivity(intent);

            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }

        num1 = (EditText) findViewById(R.id.num1);
        num1.requestFocus();
        //Playing Music
        int guessVal= getIntent().getIntExtra("GuessValue",0);
        totalGuess = guessVal;
        music = MediaPlayer.create(this,R.raw.music);
        music.setLooping(true);
        music.start();

        //Declaring TextView Update ( USED TO KEEP COUNT OF CHANCES )
        TextView update = (TextView) findViewById(R.id.update);
        update.setText("REMAINING CHANCES - " + (totalGuess) );
        //This Code is so that the previous text on edit text get erased on click
        final EditText num1 = (EditText) findViewById(R.id.num1);
        //This code check if focus is changed to the object and if so then it delete the text in it
        num1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus)
                {
                    TextKeyListener.clear((num1).getText()); // FOR CLEARING TEXT
                }
            }
        });

        //SAME HAPPENS BELOW

        final EditText num2 = (EditText) findViewById(R.id.num2);
        num2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus)
                {
                    TextKeyListener.clear((num2).getText());
                }
            }
        });
        final EditText num3 = (EditText) findViewById(R.id.num3);
        num3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus)
                {
                    TextKeyListener.clear((num3).getText());
                }
            }
        });
        final EditText num4 = (EditText) findViewById(R.id.num4);
        num4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus)
                {
                    TextKeyListener.clear((num4).getText());
                }
            }
        });

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(num1.getText().toString().length() == 1)
                {
                    num2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(num2.getText().toString().length() == 1 )
                {
                    num3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(num3.getText().toString().length() == 1 )
                {
                    num4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public void onUserLeaveHint() {
        music.stop();
        super.onUserLeaveHint();
    }
    public void onBackPressed()
    {
        music.pause();
    }

    //For Help Button

    public void jumpToHelp(View view)
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        Intent intent = new Intent(this,HelpActivity.class);
        startActivity(intent);
    }

    //For back button

    public void goMainMenu(View view)
    {
        if (interstitialAd1.isLoaded())
        {
            interstitialAd1.show();
        }
        else
        {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.clicksound);
            mp.start();
            music.stop();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }

    //This function gets called on clicking Restart
    public void restartActivity(View view){
        //Playing sound of click on restart

        if (interstitialAd.isLoaded())
        {
             interstitialAd.show();
        }
        else {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.clicksound);
            mp.start();
            music.stop();
            //Activity Calling itself
            Intent mIntent = getIntent();
            finish();
            startActivity(mIntent);
        }
    }

    //This code was used earlier to delete the text in edittext but was not used due to problems

/*
    public void onSpin1Click(View view)
    {
        EditText num1 = (EditText) findViewById(R.id.num1);
        num1.getText().clear();
    }
    public void onSpin2Click(View view)
    {
        EditText num2 = (EditText) findViewById(R.id.num2);
        num2.getText().clear();
    }
    public void onSpin3Click(View view)
    {
        EditText num3 = (EditText) findViewById(R.id.num3);
        num3.getText().clear();
    }
    public void onSpin4Click(View view)
    {
        EditText num4 = (EditText) findViewById(R.id.num4);
        num4.getText().clear();
    }
*/

//Main Function that gets called on clicking GUESS button
    public void CheckGuess(View view)
    {

        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        TextView text3 = (TextView) findViewById(R.id.text3);
        TextView text4 = (TextView) findViewById(R.id.text4);
        //Playing Click Sound
        MediaPlayer mp = MediaPlayer.create(this,R.raw.clicksound);
        mp.start();
        //Declaring Stuffs
        TextView text = (TextView)  findViewById(R.id.update);
        Button guess = (Button) findViewById(R.id.button);
        Button b = (Button) findViewById(R.id.button2);
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        EditText num3 = (EditText) findViewById(R.id.num3);
        EditText num4 = (EditText) findViewById(R.id.num4);

        //Check if any of the EditText field is not empty

        if(num1.getText().toString().length() == 0 || num2.getText().toString().length() == 0
                || num3.getText().toString().length() == 0 || num4.getText().toString().length() == 0)
        {
            text.setText("NO FIELD SHOULD BE EMPTY");
            num1.requestFocus();
            totalGuess = totalGuess + 1; // Adding so that there is no effect on totalGuess

        }
        else
            text.setText("REMAINING CHANCES - " + (totalGuess - 1));

        //Decreasing Total Guess

        totalGuess = totalGuess - 1;

        //Check if total guess is 0

        if(totalGuess < 1)
        {
            text.setTextSize(40);
            text.setText("YOU LOST");
            b.setVisibility(view.VISIBLE);
            guess.setClickable(false);
        }

        int n1 = 0,n2 =0,n3 = 0,n4 = 0;

        //Converting string to integer to compare
        if(num1.getText().toString().length() > 0) {
            n1 = Integer.parseInt(String.valueOf(num1.getText()));
            text1.setText(String.valueOf(num1.getText()));
        }

        //Check for num1
        //Change color according to result
        if(numCheck.check1(n1) == 1)
        {
            text1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        else if(numCheck.check1(n1) == 2)
        {
            text1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        else {
            text1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        if(num2.getText().toString().length() > 0) {
            n2 = Integer.parseInt(String.valueOf(num2.getText()));
            text2.setText(String.valueOf(num2.getText()));
        }

        //Check for num2
        if(numCheck.check2(n2) == 1)
        {
            text2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        else if(numCheck.check2(n2) == 2)
        {
            text2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        else {
            text2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }

        if(num3.getText().toString().length() > 0) {
            n3 = Integer.parseInt(String.valueOf(num3.getText()));
            text3.setText(String.valueOf(num3.getText()));
        }

        //Check for num3
        if(numCheck.check3(n3) == 1)
        {
            text3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        else if(numCheck.check3(n3) == 2)
        {
            text3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        else {
            text3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }

        if(num4.getText().toString().length() > 0) {
            n4 = Integer.parseInt(String.valueOf(num4.getText()));
            text4.setText(String.valueOf(num4.getText()));
        }

        if(numCheck.check4(n4) == 1)
        {
            text4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        else if(numCheck.check4(n4) == 2)
        {
            text4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        else {
            text4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }


        //Final Check if user has won or not

        if(numCheck.check1(n1) == 1 && numCheck.check2(n2) == 1 && numCheck.check3(n3) == 1 && numCheck.check4(n4) == 1)
        {
            text.setTextSize(35);

            text.setText("PIN CRACKED !");
            b.setVisibility(view.VISIBLE);
            guess.setClickable(false);
        }
        num1.getText().clear();
        num2.getText().clear();
        num3.getText().clear();
        num4.getText().clear();

        num1.requestFocus();

    }}
