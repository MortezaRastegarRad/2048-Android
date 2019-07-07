package com.example.a2048;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_screen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToPageFirst = new Intent(Splash_screen.this,MainActivity.class);
                startActivity(goToPageFirst);
            }
        },1000);

    }
}
