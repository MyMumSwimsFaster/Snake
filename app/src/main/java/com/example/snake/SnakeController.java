package com.example.snake;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/*
 * controls the moves from the snake
 * @author Kopiert von https://github.com/Linus1905/Android-Snake
 * */

public class SnakeController {

    private GameActivity gameActivity;
    private Button top;
    private Button right;
    private Button bottom;
    private Button left;
    private int directionX;
    private int directionY;


    public SnakeController(Context context) {
        gameActivity = (GameActivity) context;
        top = gameActivity.getTop();
        left = gameActivity.getLeft();
        right = gameActivity.getRight();
        bottom = gameActivity.getBottom();

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directionY = -1;
                directionX = 0;
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directionY = 0;
                directionX = 1;
            }
        });

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directionY = 1;
                directionX = 0;
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directionY = 0;
                directionX = -1;
            }
        });


    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

}