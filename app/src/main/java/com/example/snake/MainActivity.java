package com.example.snake;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int WELCOME = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent startInten = new Intent(MainActivity.this.getApplicationContext(), StartActivity.class);
              startActivity(startInten);
            }
        }, WELCOME);
    }



}
