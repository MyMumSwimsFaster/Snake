package com.example.snake;

/*
 * generates food
 * @author Kopiert von https://github.com/Linus1905/Android-Snake
 * */

public class Food {

    private int foodX;
    private int foodY;
    private final int fieldheight = 30;
    private final int fieldwidth = 30;

    public void randomFood() {
        foodX = (int) (Math.random() * (fieldwidth - 2) + 1);
        foodY = (int) (Math.random() * (fieldheight - 2) + 1);
    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }

}
