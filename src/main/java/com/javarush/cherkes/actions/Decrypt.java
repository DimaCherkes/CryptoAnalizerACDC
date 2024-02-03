package com.javarush.cherkes.actions;

import com.javarush.cherkes.constants.StaticSymbols;

import java.io.*;

public class Decrypt extends BaseAction{

    public char[] execute(char[] context, int key) {
        for (int i = 0; i < context.length; i++) {
            char ch = context[i];
            try{
                int asciiIndex = StaticSymbols.getIndexByCharacter(ch);
                char encryptedChar = StaticSymbols.getCharByIndex(asciiIndex - key);
                context[i] = encryptedChar;
            } catch (NullPointerException e) {
                context[i] = ch;
            }
        }
        return context;
    }
}
