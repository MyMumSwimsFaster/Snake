package com.example.snake;

import android.content.Context;
import android.view.View;
import android.widget.Button;

public class SnakeController {

    private GameActivity mainActivity;
    private Button top;
    private Button right;
    private Button bottom;
    private Button left;
    private int richtungX;
    private int richtungY;


    public SnakeController(Context context) {
        mainActivity = (GameActivity) context;
        top = mainActivity.gettop();
        left = mainActivity.getleft();
        right = mainActivity.getright();
        bottom = mainActivity.getbottom();

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY = -1;
                richtungX = 0;
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY = 0;
                richtungX = 1;
            }
        });

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY = 1;
                richtungX = 0;
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY = 0;
                richtungX = -1;
            }
        });


    }

    public int getRichtungX() {
        return richtungX;
    }

    public int getRichtungY() {
        return richtungY;
    }

}