package com.example.snake;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
* @author Kopiert von https://github.com/Linus1905/Android-Snake
* */

public class GameActivity extends AppCompatActivity {

    private Button top;
    private Button right;
    private Button bottom;
    private Button left;
    private TextView pointsTxt;
    private TextView pointsTxtView;
    private MediaPlayer mp = new MediaPlayer();
    private TextView highscoreTxt;
    private TextView highscoreTxtView;
    private boolean pause = false;
    private int mediaPlayerStop;
    private SnakeView snakeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top = findViewById(R.id.buttontop);
        right = findViewById(R.id.buttonright);
        bottom = findViewById(R.id.buttonbottom);
        left = findViewById(R.id.buttonleft);
        pointsTxt = findViewById(R.id.textView1);
        pointsTxtView = findViewById(R.id.textView2);
        highscoreTxt = findViewById(R.id.textView3);
        highscoreTxtView = findViewById(R.id.textView4);

        snakeView = new SnakeView(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(this.getWindow().getWindowManager().getDefaultDisplay().getWidth(), 900);
        snakeView.setLayoutParams(params);
        RelativeLayout layout = findViewById(R.id.layout1);
        snakeView.setBackgroundColor(Color.parseColor("#8caf96"));
        layout.addView(snakeView);
    }

    public Button gettop() {
        return top;
    }

    public Button getright() {
        return right;
    }

    public Button getbottom() {
        return bottom;
    }

    public Button getleft() {
        return left;
    }

    public TextView getPunkteTextView() {
        return pointsTxtView;
    }

    public TextView getHighscoreTextView() {
        return highscoreTxtView;
    }

    public boolean getPause() {
        return pause;
    }

    @Override
    public void onRestart() {
        super.onRestart();
        pause = false;
        mp.seekTo(mediaPlayerStop);
        mp.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        pause = true;
        mp.pause();
        mediaPlayerStop = mp.getCurrentPosition();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }
}