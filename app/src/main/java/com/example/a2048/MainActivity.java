package com.example.a2048;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton next_mod, prev_mod,play;
    ImageView show_mod;
    TextView mod;
    ArrayList<String> mods;
    ArrayList<Integer> images_mod;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        init();

        next_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i++;
                if (i == 5)
                    i = 0;
                mod.setText(mods.get(i));
                show_mod.setImageResource(images_mod.get(i));

            }

        });


        prev_mod.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                i--;
                if (i == -1)
                    i = 4;
                mod.setText(mods.get(i));
                show_mod.setImageResource(images_mod.get(i));

            }

        });


        play.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                switch (mod.getText().toString()){

                    case "Classic [4*4]":
                        Intent goToClassicMod = new Intent(MainActivity.this,classic_page.class);
                        startActivity(goToClassicMod);
                        break;
                    case "Big [5*5]":
                        Intent goToBigMod = new Intent(MainActivity.this,classic_page.class);
                        startActivity(goToBigMod);
                        break;
                    case "Bigger [6*6]":
                        Intent goToBiggerMod = new Intent(MainActivity.this,classic_page.class);
                        startActivity(goToBiggerMod);
                        break;
                    case "Huge [8*8]":
                        Intent goToHugeMod = new Intent(MainActivity.this,classic_page.class);
                        startActivity(goToHugeMod);
                        break;
                    case "Small [3*3]":
                        Intent goToSmallMod = new Intent(MainActivity.this,Small_page.class);
                        startActivity(goToSmallMod);
                        break;

                }

            }

        });

    }


    void init() {

        next_mod = (ImageButton) findViewById(R.id.next_mod);
        prev_mod = (ImageButton) findViewById(R.id.prev_mod);
        play = (ImageButton) findViewById(R.id.play);
        show_mod = (ImageView) findViewById(R.id.show_mod);
        mod = (TextView) findViewById(R.id.mod);
        mods = new ArrayList<>();
        mods.add("Classic [4*4]");
        mods.add("Big [5*5]");
        mods.add("Bigger [6*6]");
        mods.add("Huge [8*8]");
        mods.add("Small [3*3]");
        i = 0;
        images_mod = new ArrayList<>();
        images_mod.add(R.drawable.classic);
        images_mod.add(R.drawable.big);
        images_mod.add(R.drawable.bigger);
        images_mod.add(R.drawable.huge);
        images_mod.add(R.drawable.small);

    }

}
