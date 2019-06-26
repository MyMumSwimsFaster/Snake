package com.example.snake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Button playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(this);
        Button exit = findViewById(R.id.exitGame);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.exitGame:
                finish();
                this.closeContextMenu();
                moveTaskToBack(true);
                closeContextMenu();
                System.exit(1);
            case R.id.playAgain:
                Intent startIntent = new Intent(EndActivity.this.getApplicationContext(), IngameActivity.class);
                        startActivity(startIntent);
        }
    }
}
