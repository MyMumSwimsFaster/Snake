package com.example.snake;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class SchlangeView extends SurfaceView implements SurfaceHolder.Callback {

    private Timer timer;
    private TimerTask timerTask;
    private com.example.snake.SchlangeModel schlangeModel;
    private GameActivity mainActivity;
    private com.example.snake.SchlangeController schlangeController;
    private boolean pause;
    private LinkedList<Point> snake = new LinkedList<Point>();
    private int richtungX;
    private int richtungY;
    private int futterX;
    private int futterY;
    private final int kästchenGröße = 30;
    private com.example.snake.Futter futter;
    private com.example.snake.Punkte punkte;
    private TextView punkteTextView;
    private TextView highscoretextView;

    public SchlangeView(Context context) {
        super(context);
        mainActivity = (GameActivity) context;
        schlangeModel = new com.example.snake.SchlangeModel(context);
        punkte = schlangeModel.getPunkte();
        punkteTextView = mainActivity.getPunkteTextView();
        highscoretextView = mainActivity.getHighscoreTextView();
        futter = schlangeModel.getFutter();
        schlangeController = new com.example.snake.SchlangeController(context);
        initialiesierePunkteStand();
        gameLoop();
    }

    private void initialiesierePunkteStand() {
        punkte.setPunkte(0);
        punkte.setHighscore(punkte.ladeHighscore());
        punkteTextView.setText("" + 0);
        highscoretextView.setText("" + punkte.getHighscore());
    }

    private void verwaltePunkte() {
        if (punkte.getPunkte() > punkte.ladeHighscore()) {

            punkte.setHighscore(punkte.getPunkte());
            highscoretextView.setText("" + punkte.getHighscore());
        }
        punkteTextView.setText("" + punkte.getPunkte());
    }

    public void gameLoop() {
        timer = new Timer();
        timerTask = new TimerTask() {

            @Override
            public void run() {
                mainActivity.runOnUiThread(new TimerTask() {

                    @Override
                    public void run() {
                        pause = mainActivity.getPause();
                        verwaltePunkte();
                        if (pause == false && isGameOver() == false) {

                            richtungX = schlangeController.getRichtungX();
                            richtungY = schlangeController.getRichtungY();

                            schlangeModel.bewegungSchlange(richtungX, richtungY);
                            snake = schlangeModel.getSnake();
                            invalidate();
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000, 150);
    }

    public void showGameOverScreen() {
        Intent intent = new Intent(getContext(), EndActivity.class);
        getContext().startActivity(intent);
    }

    public boolean isGameOver() {

        if (schlangeModel.gameOver() == true) {
            punkte.schreibeHighscore();
            timer.cancel();
            showGameOverScreen();
        }
        return false;
    }

    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint p = new Paint();
        snake = schlangeModel.getSnake();
        futterX = futter.getFutterX();
        futterY = futter.getFutterY();

        p.setColor(Color.RED);
        canvas.drawRect(futterX * kästchenGröße, futterY * kästchenGröße, futterX * kästchenGröße + kästchenGröße, futterY * kästchenGröße + kästchenGröße, p);

        for (int i = 0; i < snake.size(); i++) {
            Point point;

            if (i == 0) {
                p.setColor(Color.BLACK);
                point = snake.get(i);
                canvas.drawRect(point.x * kästchenGröße, point.y * kästchenGröße, point.x * kästchenGröße + kästchenGröße, point.y * kästchenGröße + kästchenGröße, p);
            } else {
                p.setColor(Color.BLACK);
                point = snake.get(i);
                canvas.drawRect(point.x * kästchenGröße, point.y * kästchenGröße, point.x * kästchenGröße + kästchenGröße, point.y * kästchenGröße + kästchenGröße, p);
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

}