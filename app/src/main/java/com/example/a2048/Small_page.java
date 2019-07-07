package com.example.a2048;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

public class Small_page extends AppCompatActivity implements Mod {

    TextView Score, HighScore, i00, i01, i02, i10, i11, i12, i20, i21, i22;
    Button reStart;
    int highScore, score;
    String[][] a;
    int Long;
    Small_page instance;
    GesterListener gesterListener;
    GestureDetectorCompat gestureDetectorCompat;

    Small_page() {
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.small_page);

        instance = new Small_page();

    }

    void init() {

        Score = (TextView) findViewById(R.id.Score);
        HighScore = (TextView) findViewById(R.id.HighScore);
        i00 = (TextView) findViewById(R.id.i00);
        i01 = (TextView) findViewById(R.id.i01);
        i02 = (TextView) findViewById(R.id.i02);
        i10 = (TextView) findViewById(R.id.i10);
        i11 = (TextView) findViewById(R.id.i11);
        i12 = (TextView) findViewById(R.id.i12);
        i20 = (TextView) findViewById(R.id.i20);
        i21 = (TextView) findViewById(R.id.i21);
        i22 = (TextView) findViewById(R.id.i22);
        reStart = (Button) findViewById(R.id.Restart_btn);
        Long = 3;
        a = new String[Long][Long];
        gesterListener = new GesterListener();
        gesterListener.setActivity(Small_page.this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gesterListener);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetectorCompat.onTouchEvent(event);

        return true;
    }


    @Override
    public Small_page Instance() {
        return Small_page.this;
    }
}
