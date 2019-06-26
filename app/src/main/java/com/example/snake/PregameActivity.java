package com.example.snake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PregameActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregame);
        Button tapToPlay = findViewById(R.id.tapToPlay);
        View view = findViewById(R.id.ingameview);
        Button helpButton = findViewById(R.id.helpButton);
        tapToPlay.setOnClickListener(this);
        view.setOnClickListener(this);
        helpButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tapToPlay:
            case R.id.ingameview:
                Intent startIntent = new Intent(PregameActivity.this.getApplicationContext(), GameActivity.class);
                startActivity(startIntent);
        }
        switch(view.getId()){
            case R.id.helpButton:
                Intent startInten = new Intent(PregameActivity.this.getApplicationContext(), HelpActivity.class);
                startActivity(startInten);
        }
    }
}
