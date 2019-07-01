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

/*
 * draws the gamefield and handles the points
 * @author Kopiert von https://github.com/Linus1905/Android-Snake
 * */

public class SnakeView extends SurfaceView implements SurfaceHolder.Callback {

    private Timer timer;
    private TimerTask timerTask;
    private SnakeModel snakeModel;
    private GameActivity gameActivity;
    private SnakeController snakeController;
    private boolean pause;
    private LinkedList<Point> snake = new LinkedList<Point>();
    private int directionX;
    private int directionY;
    private int foodX;
    private int foodY;
    private final int boxSize = 30;
    private Food food;
    private Points points;
    private TextView pointsTxtView;
    private TextView highscoreTxtView;

    public SnakeView(Context context) {
        super(context);
        gameActivity = (GameActivity) context;
        snakeModel = new SnakeModel(context);
        points = snakeModel.getPoints();
        pointsTxtView = gameActivity.getPointsTxtView();
        highscoreTxtView = gameActivity.getHighscoreTxtView();
        food = snakeModel.getFood();
        snakeController = new SnakeController(context);
        initialiseScore();
        gameLoop();
    }

    private void initialiseScore() {
        points.setPoints(0);
        points.setHighscore(points.loadHighscore());
        pointsTxtView.setText("" + 0);
        highscoreTxtView.setText("" + points.getHighscore());
    }

    private void managePoints() {
        if (points.getPoints() > points.loadHighscore()) {

            points.setHighscore(points.getPoints());
            highscoreTxtView.setText("" + points.getHighscore());
        }
        pointsTxtView.setText("" + points.getPoints());
    }

    public void gameLoop() {
        timer = new Timer();
        timerTask = new TimerTask() {

            @Override
            public void run() {
                gameActivity.runOnUiThread(new TimerTask() {

                    @Override
                    public void run() {
                        pause = gameActivity.getPause();
                        managePoints();
                        if (pause == false && isGameOver() == false) {

                            directionX = snakeController.getDirectionX();
                            directionY = snakeController.getDirectionY();

                            snakeModel.motionSnake(directionX, directionY);
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
        String points = Points.getPoints() + "";
        String highscore = Points.getHighscore() + "";
        intent.putExtra("Score", points);
        intent.putExtra("Highscore", highscore);
        getContext().startActivity(intent);
    }

    public boolean isGameOver() {

        if (snakeModel.gameOver() == true) {
            points.writeHighscore();
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
        foodX = food.getFoodX();
        foodY = food.getFoodY();

        p.setColor(Color.RED);
        canvas.drawRect(foodX * boxSize, foodY * boxSize, foodX * boxSize + boxSize, foodY * boxSize + boxSize, p);

        for (int i = 0; i < snake.size(); i++) {
            Point point;

            if (i == 0) {
                p.setColor(Color.BLACK);
                point = snake.get(i);
                canvas.drawRect(point.x * boxSize, point.y * boxSize, point.x * boxSize + boxSize, point.y * boxSize + boxSize, p);
            } else {
                p.setColor(Color.BLACK);
                point = snake.get(i);
                canvas.drawRect(point.x * boxSize, point.y * boxSize, point.x * boxSize + boxSize, point.y * boxSize + boxSize, p);
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