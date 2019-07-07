package com.example.a2048;

import android.app.Activity;
import android.os.Bundle;

public class classic_page extends Activity implements Mod{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Object Instance() {
        return null;
    }

    @Override
    public String[][] array() {
        return new String[0][];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void result(String[][] array, String Message) {

    }
}
