package com.example.snake;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

/*
 * calls activity_start
 * @author Kevin Thurnes, Alessandro Bachmann & Besfort Dauti
 * */

public class StartActivity extends AppCompatActivity {

    public final static int WELCOME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startInten = new Intent(StartActivity.this.getApplicationContext(), PregameActivity.class);
                startActivity(startInten);
            }
        }, WELCOME);
    }


}
