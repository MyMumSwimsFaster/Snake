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

public class SnakeView extends SurfaceView implements SurfaceHolder.Callback {

    private Timer timer;
    private TimerTask timerTask;
    private SnakeModel snakeModel;
    private GameActivity mainActivity;
    private SnakeController snakeController;
    private boolean pause;
    private LinkedList<Point> snake = new LinkedList<Point>();
    private int richtungX;
    private int richtungY;
    private int futterX;
    private int futterY;
    private final int kästchenGröße = 30;
    private Food food;
    private Points points;
    private TextView punkteTextView;
    private TextView highscoretextView;

    public SnakeView(Context context) {
        super(context);
        mainActivity = (GameActivity) context;
        snakeModel = new SnakeModel(context);
        points = snakeModel.getPoints();
        punkteTextView = mainActivity.getPunkteTextView();
        highscoretextView = mainActivity.getHighscoreTextView();
        food = snakeModel.getFood();
        snakeController = new SnakeController(context);
        initialiesierePunkteStand();
        gameLoop();
    }

    private void initialiesierePunkteStand() {
        points.setPunkte(0);
        points.setHighscore(points.ladeHighscore());
        punkteTextView.setText("" + 0);
        highscoretextView.setText("" + points.getHighscore());
    }

    private void verwaltePunkte() {
        if (points.getPunkte() > points.ladeHighscore()) {

            points.setHighscore(points.getPunkte());
            highscoretextView.setText("" + points.getHighscore());
        }
        punkteTextView.setText("" + points.getPunkte());
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

                            richtungX = snakeController.getRichtungX();
                            richtungY = snakeController.getRichtungY();

                            snakeModel.bewegungSchlange(richtungX, richtungY);
                            snake = snakeModel.getSnake();
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

        if (snakeModel.gameOver() == true) {
            points.schreibeHighscore();
            timer.cancel();
            showGameOverScreen();
        }
        return false;
    }

    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint p = new Paint();
        snake = snakeModel.getSnake();
        futterX = food.getFutterX();
        futterY = food.getFutterY();

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