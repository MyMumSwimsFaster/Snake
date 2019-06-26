package com.example.snake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IngameActivity extends Activity implements View.OnClickListener {

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

    Button credits = findViewById(R.id.creditsButton);
    credits.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.creditsButton:
                Intent startInten = new Intent(IngameActivity.this.getApplicationContext(), EndActivity.class);
                startActivity(startInten);
        }
    }
}
