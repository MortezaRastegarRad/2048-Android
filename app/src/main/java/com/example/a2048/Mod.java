package com.example.a2048;

public interface Mod<T> {

    T Instance();//dosent work
    String[][] array();
    int size();
    void result(String [][] array,String Message);
}
