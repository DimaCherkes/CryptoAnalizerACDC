package com.javarush.cherkes.actions;

import com.javarush.cherkes.constants.StaticSymbols;


public abstract class BaseAction {
    private int key;

    public BaseAction(int key) {
        this.key = key;
    }

    public char[] execute(char[] context) {
        char[] result = new char[context.length];
        for (int i = 0; i < context.length; i++) {
            char ch = context[i];
            try{
                int asciiIndex = StaticSymbols.getIndexByCharacter(ch);
                int completeIndex = getCompleteIndex(asciiIndex);
                char encryptedChar = StaticSymbols.getCharByIndex(completeIndex);
                result[i] = encryptedChar;
            } catch (NullPointerException e) {
                result[i] = ch;
            }
        }
        return result;
    }

    protected int getCompleteIndex(int asciiIndex) {
        while (key > StaticSymbols.NUMBER_OF_CHARACTERS) {
            key -= StaticSymbols.NUMBER_OF_CHARACTERS;
        }
        // using getKey() not key, because for decrypting key must be opposite, so I override getKey() for Decrypt class
        int completeIndex = asciiIndex + getKey();
        if (completeIndex > StaticSymbols.UPPER_INDEX_OF_ASCII) {
            int delta = completeIndex - StaticSymbols.UPPER_INDEX_OF_ASCII;
            completeIndex = StaticSymbols.DOWN_INDEX_OF_ASCII + delta - 1;
        } else if (completeIndex < StaticSymbols.DOWN_INDEX_OF_ASCII) {
            int delta = StaticSymbols.DOWN_INDEX_OF_ASCII - completeIndex;
            completeIndex = StaticSymbols.UPPER_INDEX_OF_ASCII - delta + 1;
        }
        return completeIndex;
    }

    public int getKey() {
        return key;
    }

}
