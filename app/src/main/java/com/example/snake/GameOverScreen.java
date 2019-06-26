package com.example.snake;

import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverScreen extends AppCompatActivity implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

   /* private ZeichenView zw;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        zw = new ZeichenView(this);
        layout.setOnTouchListener(this);
        layout.addView(zw);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int aktion = event.getAction();

        if (aktion == MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(this, GameActivity.class);
            this.startActivity(intent);
            return true;
        }

        return false;
    }

    class ZeichenView extends View {

        ZeichenView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            p.setTextSize(200);
            canvas.drawText("Game Over", 50, 400, p);
            p.setTextSize(75);

            canvas.drawText("Deine Punkte:" + Punkte.getPunkte(), 300, 600, p);
            //Punkte.resetPunkte();
        }
    }*/
}