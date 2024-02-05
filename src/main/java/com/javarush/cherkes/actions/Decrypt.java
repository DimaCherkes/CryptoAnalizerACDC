package com.javarush.cherkes.actions;


public class Decrypt extends BaseAction{

    public Decrypt(int key) {
        super(key);
    }

    @Override
    public int getKey(){
        return (-1) * super.getKey();
    }

}
