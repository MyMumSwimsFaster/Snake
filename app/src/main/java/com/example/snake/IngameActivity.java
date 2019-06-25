package com.example.snake;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class IngameActivity extends Activity {

    private SnakeEngine snakeEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingame);

        View gameview = findViewById(R.id.gameview);
/*
        // Create a new instance of the SnakeEngine class
        snakeEngine = new SnakeEngine(this, size);

        // Make snakeEngine the view of the Activity
        gameview(snakeEngine);
*/
    }

}
