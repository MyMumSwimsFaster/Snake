package com.example.snake;

import android.content.Context;
import android.graphics.Point;

import java.util.LinkedList;

/*
 */

public class SnakeModel {

    private LinkedList<Point> snake = new LinkedList<Point>();
    private SnakeController snakeController;
    private final int feldHöhe = 30;
    private final int feldBreite = 33;
    private Food food;
    private int futterX;
    private int futterY;
    private int aktuellePunkte = 0;
    private Points points;


    public SnakeModel(Context context) {
        food = new Food();
        food.zufälligesEssen();
        startPunktSchlange();
        points = new Points(context);
    }

    public void startPunktSchlange() {
        int randomX = (int) (Math.random() * (feldBreite - 2) + 1);
        int randomY = (int) (Math.random() * (feldHöhe - 2) + 1);
        snake.addFirst(new Point(randomX, randomY));
    }

    public void bewegungSchlange(int richtungX, int richtungY) {

        for (int i = snake.size() - 1; i > 0; i--) {
            Point tmp = snake.get(i);
            tmp.set(snake.get(i - 1).x, snake.get(i - 1).y);
        }

        snake.getFirst().x += richtungX;
        snake.getFirst().y += richtungY;
        essen();
    }

    public void essen() {
        futterX = food.getFutterX();
        futterY = food.getFutterY();

        if (snake.getFirst().x == futterX && snake.getFirst().y == futterY) { // eat Apple
            snake.addLast(new Point(snake.getLast().x - 1, snake.getLast().y));
            food.zufälligesEssen();
            aktuellePunkte = aktuellePunkte + 1;
            points.setPunkte(aktuellePunkte);
        }
    }

    public boolean gameOver() {

        for (int i = 1; i < snake.size(); i++) {
            if (snake.getFirst().x == snake.get(i).x && snake.getFirst().y == snake.get(i).y) {
                return true;
            }
        }

        if (snake.getFirst().x < 0 || snake.getFirst().x > 33 || snake.getFirst().y < 0 || snake.getFirst().y > 29) {
            return true;
        }
        return false;
    }

    public Points getPoints() {
        return points;
    }

    public Food getFood() {
        return food;
    }

    public LinkedList<Point> getSnake() {
        return snake;
    }

}