package com.javarush.kudra.commands;

import com.javarush.kudra.Result;

public class Decode extends AbstractActions {
    @Override
    public Result execute(String[] parameters) {
        String encodedFile = parameters[0];
        String decodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return changeWithKey(encodedFile,decodedFile,key);
    }
}
