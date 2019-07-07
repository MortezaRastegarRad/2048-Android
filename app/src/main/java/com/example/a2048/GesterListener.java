package com.example.a2048;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class GesterListener extends GestureDetector.SimpleOnGestureListener {


    private int MAX_Distance_Of_swipe_X = 1000;
    private int MAX_Distance_Of_swipe_Y = 1000;

    private int MIN_Distance_Of_swipe_X = 100;
    private int MIN_Distance_Of_swipe_Y = 100;


    private Mod activity;

    public Mod getActivity() {
        return activity;
    }

    public void setActivity(Mod activity) {
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        float DistanceX = Math.abs(deltaX);
        float DistanceY = Math.abs(deltaY);


        if (DistanceX > MIN_Distance_Of_swipe_X && DistanceX < MAX_Distance_Of_swipe_X) {

            if (deltaX > 0){
                //left

                left(getActivity().Instance().a);

            }
            else {
                //right


            }

        } else {

            if (DistanceY > MIN_Distance_Of_swipe_Y && DistanceY < MAX_Distance_Of_swipe_Y) {

                if (deltaY>0){
                    //down

                }
                else {
                    //up


                }

            }

        }

        return true;
    }


    static void left(String[][] a) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!a[i][j].equals("X")) {
                    a[i][counter] = a[i][j];
                    if (counter != j) {
                        a[i][j] = "X";
                    }
                    counter++;
                }
            }
            counter = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3-1; j++) {
                if (a[i][j].equals(a[i][j + 1]) && !a[i][j].equals("X")) {
                    int b1 = Integer.valueOf(a[i][j]);
                    int b2 = b1 * 2;
                    a[i][j] = String.valueOf(b2);
                    for (int k = j+2; k <3-1 ; k++) {
                        a[i][k-1]=a[i][k];
                    }
                    a[i][3-1] = "X";
                }
            }
        }
    }


}
