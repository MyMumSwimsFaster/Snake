package com.example.snake;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IngameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ingame);
    Button button1 = findViewById(R.id.tapToPlay);
    View view = findViewById(R.id.ingameview);
    button1.setOnClickListener(this);
    view.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tapToPlay:
                setContentView(R.layout.activity_snake);
            case R.id.ingameview:
                setContentView(R.layout.activity_snake);
        }
    }
}