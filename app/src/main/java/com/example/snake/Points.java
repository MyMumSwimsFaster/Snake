package com.example.snake;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * handles the actual points and the highscore
 * @author Kopiert von https://github.com/Linus1905/Android-Snake
 * */

public class Points {

    private static int highscore;
    private static int points;
    private GameActivity gameActivity;

    public Points(Context context) {
        gameActivity = (GameActivity) context;
    }

    public void writeHighscore() {
        SharedPreferences pref = gameActivity.getSharedPreferences("GAME", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("HIGHSCORE", highscore);
        editor.commit();
    }

    public int loadHighscore() {
        SharedPreferences pref = gameActivity.getSharedPreferences("GAME", 0);
        return pref.getInt("HIGHSCORE", 0);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static int getPoints() {
        return points;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public static int getHighscore() {
        return highscore;
    }

}