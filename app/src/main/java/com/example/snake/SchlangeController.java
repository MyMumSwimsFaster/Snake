package com.example.snake;

import android.content.Context;
import android.view.View;
import android.widget.Button;

public class SchlangeController {//implements View.OnClickListener {

    private GameActivity mainActivity;
    private Button hoch;
    private Button rechts;
    private Button unten;
    private Button links;
    private int richtungX;
    private int richtungY;


    public SchlangeController(Context context) {
        mainActivity = (GameActivity) context;
        hoch = mainActivity.getHoch();
        links = mainActivity.getLinks();
        rechts = mainActivity.getRechts();
        unten = mainActivity.getUnten();

        hoch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY=-1;
                richtungX=0;
            }
        });

        rechts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY=0;
                richtungX=1;
            }
        });

        unten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY=1;
                richtungX=0;
            }
        });

        links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richtungY=0;
                richtungX=-1;
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