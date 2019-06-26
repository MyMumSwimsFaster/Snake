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
        tapToPlay.setOnClickListener(this);
        view.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tapToPlay:
            case R.id.ingameview:
                Intent startInten = new Intent(PregameActivity.this.getApplicationContext(), IngameActivity.class);
                startActivity(startInten);
        }
    }
}
