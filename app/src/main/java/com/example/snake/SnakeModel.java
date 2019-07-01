package com.example.snake;

import android.content.Context;
import android.graphics.Point;

import java.util.LinkedList;

/*
 * handles the points/food from the game
 * @author Kopiert von https://github.com/Linus1905/Android-Snake
 * */

public class SnakeModel {

    private LinkedList<Point> snake = new LinkedList<Point>();
    private final int fieldheight = 30;
    private final int fieldwidth = 33;
    private Food food;
    private int foodX;
    private int foodY;
    private int currentPoints = 0;
    private Points points;


    public SnakeModel(Context context) {
        food = new Food();
        food.randomFood();
        startPointSnake();
        points = new Points(context);
    }

    public void startPointSnake() {
        int randomX = (int) (Math.random() * (fieldwidth - 2) + 1);
        int randomY = (int) (Math.random() * (fieldheight - 2) + 1);
        snake.addFirst(new Point(randomX, randomY));
    }

    public void motionSnake(int directionX, int directionY) {

        for (int i = snake.size() - 1; i > 0; i--) {
            Point tmp = snake.get(i);
            tmp.set(snake.get(i - 1).x, snake.get(i - 1).y);
        }

        snake.getFirst().x += directionX;
        snake.getFirst().y += directionY;
        food();
    }

    public void food() {
        foodX = food.getFoodX();
        foodY = food.getFoodY();

        if (snake.getFirst().x == foodX && snake.getFirst().y == foodY) { // eat Apple
            snake.addLast(new Point(snake.getLast().x - 1, snake.getLast().y));
            food.randomFood();
            currentPoints = currentPoints + 1;
            points.setPoints(currentPoints);
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