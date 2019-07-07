package com.example.a2048;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Small_page extends AppCompatActivity implements Mod {

    TextView Score, HighScore, i00, i01, i02, i10, i11, i12, i20, i21, i22;
    Button reStart;
    TextView[][] textViews;
    int highScore, score;
    String[][] a;
    int Long;
    Small_page instance;
    GesterListener gesterListener;
    GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.small_page);

        init();

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
        textViews = new TextView[Long][Long];
        textViews[0][0] = i00;        textViews[0][1] = i01;        textViews[0][2] = i02;
        textViews[1][0] = i10;        textViews[1][1] = i11;        textViews[1][2] = i12;
        textViews[2][0] = i20;        textViews[2][1] = i21;        textViews[2][2] = i22;
        a = new String[Long][Long];
        SetText();
        random(a);//initialize array of String
        random(a);
        Set(a);// initialize array of TextView
        instance = Small_page.this;
        gesterListener = new GesterListener();
        gesterListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gesterListener);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetectorCompat.onTouchEvent(event);

        return true;
    }


    @Override//doesn't work
    public Small_page Instance() {
        return Small_page.this;
    }

    @Override
    public String[][] array() {
        return a;
    }
    @Override
    public int size(){
        return Long;
    }

    @Override
    public void result(String[][] array,String Message) {//set array of String to array of TextView

        for (int i = 0; i < Long; i++) {
            for (int j = 0; j < Long; j++) {
                textViews[i][j].setText(array[i][j]);
            }
        }

        if (Message.equals("NO")){
            new AlertDialog.Builder(this).setMessage("Game over!").setNeutralButton("Play agian", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent goToPageFirst = new Intent(Small_page.this,MainActivity.class);
                    startActivity(goToPageFirst);

                }
            });
        }

    }

    private void SetText() {//set array of TextView to array of String for first time
        for (int i = 0; i < Long; i++) {
            for (int j = 0; j < Long; j++) {
                a[i][j] = textViews[i][j].getText().toString();
            }
        }
    }

    private void Set(String[][] a){//set array of String to array of TextView
        for (int i = 0; i < Long; i++) {
            for (int j = 0; j < Long; j++) {
                textViews[i][j].setText(a[i][j]);
            }
        }
    }


    private void random(String[][] a) {// array of String with random number
        boolean flag = false;
        Random rand = new Random();
        int fourOrTwo;
        int row, column;
        for (int i = 0; i < Long; i++) {
            for (int j = 0; j < Long; j++) {
                if (a[i][j].equals("")) {
                    flag = true;
                }
            }
        }
        while (flag) {
            row = rand.nextInt(Long);
            column = rand.nextInt(Long);
            fourOrTwo = rand.nextInt(101);
            if (a[row][column].equals("")) {
                if (fourOrTwo % 2 == 0)
                    a[row][column] = "2";
                else
                    a[row][column] = "4";
                flag = false;
            }
        }
    }

    void Show(){
        for (int i = 0; i < Long; i++) {
            for (int j = 0; j < Long; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
