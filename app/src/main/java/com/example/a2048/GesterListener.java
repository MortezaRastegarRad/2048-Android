package com.example.a2048;

import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Random;

public class GesterListener extends GestureDetector.SimpleOnGestureListener {


    private int MAX_Distance_Of_swipe_X = 1000;
    private int MAX_Distance_Of_swipe_Y = 1000;

    private int MIN_Distance_Of_swipe_X = 200;
    private int MIN_Distance_Of_swipe_Y = 200;


    private static Mod activity;
    private static int Length;
    private static String[][] copArray;
    private static String[][] copArray2;
    private static int b = 1;

    public Mod getActivity() {
        return activity;
    }

    public void setActivity(Mod activity) {
        this.activity = activity;
        Length = activity.size();
        System.out.println(Length + "= Length");
        copArray = activity.array();
        Show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if(!Check(copArray)){
            activity.result(copArray,"NO");
        }

        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        System.out.println("deltaX = " + deltaX);
        System.out.println("deltaY = " + deltaY);

        float DistanceX = Math.abs(deltaX);
        float DistanceY = Math.abs(deltaY);
        System.out.println(DistanceX + "= XDistanceY = " + DistanceY);

        if (DistanceX > MIN_Distance_Of_swipe_X && DistanceX < MAX_Distance_Of_swipe_X) {

            if (deltaX > 0) {
                //left
                System.out.println("left");
                copArray2 = copy(copArray);
                left(copArray);
                if (!Change(copArray, copArray2)) {
                    b = random(copArray);
                }

                if (b == 0) {
                    activity.result(copArray, "NO");
                } else {
                    activity.result(copArray, "YES");
                }

                Show();
            } else {
                //right
                System.out.println("right");
                copArray2 = copy(copArray);
                right(activity.array());
                if (!Change(copArray, copArray2)) {
                    b = random(copArray);
                }

                if (b == 0) {
                    activity.result(copArray, "NO");
                } else {
                    activity.result(copArray, "YES");
                }

                Show();
            }

        } else {

            if (DistanceY > MIN_Distance_Of_swipe_Y && DistanceY < MAX_Distance_Of_swipe_Y) {

                if (deltaY < 0) {
                    //down
                    System.out.println("down");
                    copArray2 = copy(copArray);
                    down(copArray);
                    if (!Change(copArray, copArray2)) {
                        b = random(copArray);
                    }

                    if (b == 0) {
                        activity.result(copArray, "NO");
                    } else {
                        activity.result(copArray, "YES");
                    }

                    Show();
                } else {
                    //up
                    System.out.println("up");
                    copArray2 = copy(copArray);
                    up(copArray);
                    if (!Change(copArray, copArray2)) {
                        b = random(copArray);
                    }

                    if (b == 0) {
                        activity.result(copArray, "NO");
                    } else {
                        activity.result(copArray, "YES");
                    }

                    Show();
                }
            }
        }
        return true;
    }


    static void left(String[][] a) {
        int counter = 0;
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                if (!a[i][j].equals("")) {
                    a[i][counter] = a[i][j];
                    if (counter != j) {
                        a[i][j] = "";
                    }
                    counter++;
                }
            }
            counter = 0;
        }
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length - 1; j++) {
                if (a[i][j].equals(a[i][j + 1]) && !a[i][j].equals("")) {
                    int b1 = Integer.valueOf(a[i][j]);
                    int b2 = b1 * 2;
                    a[i][j] = String.valueOf(b2);
                    for (int k = j + 2; k < Length - 1; k++) {
                        a[i][k - 1] = a[i][k];
                    }
                    a[i][Length - 1] = "";
                }
            }
        }
    }


    static void right(String[][] a) {
        int counter = Length - 1;
        for (int i = 0; i < Length; i++) {
            for (int j = Length - 1; j >= 0; j--) {
                if (!a[i][j].equals("")) {
                    a[i][counter] = a[i][j];
                    if (j != counter) {
                        a[i][j] = "";
                    }
                    counter--;
                }
            }
            counter = Length - 1;
        }
        for (int i = 0; i < Length; i++) {
            for (int j = Length - 1; j > 0; j--) {
                if (a[i][j].equals(a[i][j - 1]) && !a[i][j].equals("")) {
                    int b1 = Integer.valueOf(a[i][j]);
                    int b2 = b1 * 2;
                    a[i][j] = String.valueOf(b2);
                    System.arraycopy(a[i], 0, a[i], 1, j - 1);
                    a[i][0] = "";
                }
            }
        }
    }


    static void down(String[][] a) {
        int counter = Length - 1;
        for (int i = Length - 1; i >= 0; i--) {
            for (int j = Length - 1; j >= 0; j--) {
                if (!a[j][i].equals("")) {
                    a[counter][i] = a[j][i];
                    if (counter != j) {
                        a[j][i] = "";
                    }
                    counter--;
                }
            }
            counter = Length - 1;
        }
        for (int i = Length - 1; i >= 0; i--) {
            for (int j = Length - 2; j >= 0; j--) {
                if (a[j + 1][i].equals(a[j][i]) && !a[j][i].equals("")) {
                    int b1 = Integer.valueOf(a[j + 1][i]);
                    int b2 = b1 * 2;
                    a[j + 1][i] = String.valueOf(b2);
                    for (int k = j; k > 0; k--) {
                        a[k][i] = a[k - 1][i];
                    }
                    a[0][i] = "";
                }
            }
        }
    }


    static void up(String[][] a) {
        int counter = 0;
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                if (!a[j][i].equals("")) {
                    a[counter][i] = a[j][i];
                    if (counter != j) {
                        a[j][i] = "";
                    }
                    counter++;
                }
            }
            counter = 0;
        }
        int j, i;
        for (i = 0; i < Length; i++) {
            for (j = 0; j < Length - 1; j++) {
                if (a[j + 1][i].equals(a[j][i]) && !a[j][i].equals("")) {
                    int b1 = Integer.valueOf(a[j + 1][i]);
                    int b2 = Integer.valueOf(a[j][i]);
                    int b3 = b1 + b2;
                    a[j][i] = String.valueOf(b3);
                    for (int k = j + 1; k < Length - 1; k++) {
                        a[k][i] = a[k + 1][i];
                    }
                    a[Length - 1][i] = "";
                }
            }
        }
    }


    public static String[][] copy(String[][] game) {
        String[][] a = new String[Length][Length];
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                a[i][j] = game[i][j];
            }
        }
        return a;
    }


    private static int random(String[][] a) {
        boolean flag = false;
        Random rand = new Random();
        int fourOrTwo;
        int row, column;
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                if (a[i][j].equals("")) {
                    flag = true;
                }
            }
        }
        if (flag) {
            while (flag) {
                row = rand.nextInt(Length);
                column = rand.nextInt(Length);
                fourOrTwo = rand.nextInt(101);
                if (a[row][column].equals("")) {
                    if (fourOrTwo % 2 == 0)
                        a[row][column] = "2";
                    else
                        a[row][column] = "4";
                    flag = false;
                }
            }
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean Change(String[][] a, String[][] b) {
        boolean flag = true;
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                if (!a[i][j].equals(b[i][j])) {
                    flag = false;
                }
            }
        }
        return flag;
    }


    void Show() {
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                System.out.print(copArray[i][j] + "\t");
            }
            System.out.println();
        }
    }


    boolean Check(String[][] a) {

        boolean flag = false;

        for (int i = 0; i < Length-1; i++) {
            for (int j = 0; j < Length - 1; j++) {

                if (a[i][j].equals(a[i][j + 1]) || a[i][j].equals(a[i+1][j])) {
                    flag = true;
                }

            }
        }

        return flag;
    }

}
