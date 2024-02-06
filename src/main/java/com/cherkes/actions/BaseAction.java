package com.cherkes.actions;

import com.cherkes.constants.StaticSymbols;

/**
 * This abstract class provides a basic structure for actions that involve the encryption or decryption of a given context.
 */
public abstract class BaseAction {

    /**
     * The key used for the encryption or decryption process.
     */
    private int key;

    /**
     * Constructs a new BaseAction instance with a given key.
     *
     * @param key the key used for the encryption or decryption process
     */
    public BaseAction(int key) {
        this.key = key;
    }

    /**
     * Executes the encryption or decryption process on the provided context using the specified key.
     *
     * @param context the array of characters representing the input context
     * @return the result of the encryption or decryption process as an array of characters
     */
    public char[] execute(char[] context) {
        char[] result = new char[context.length];
        for (int i = 0; i < context.length; i++) {
            char ch = context[i];
            try {
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

    /**
     * Returns the complete index of a given ASCII index based on the key
     * ranging from {@value StaticSymbols#DOWN_INDEX_OF_ASCII} to {@value StaticSymbols#UPPER_INDEX_OF_ASCII} .
     *
     * @param asciiIndex the ASCII index of a character
     * @return the complete index as an integer
     */
    public int getCompleteIndex(int asciiIndex) {
        while (key < 0 ){
            key += StaticSymbols.NUMBER_OF_CHARACTERS;
        }
        while (key > StaticSymbols.NUMBER_OF_CHARACTERS) {
            key -= StaticSymbols.NUMBER_OF_CHARACTERS;
        }
        // Using getKey() instead of key, as for decryption, the key must be the opposite.
        // Override getKey() in the Decrypt class to provide the correct key.
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

    /**
     * Gets the key used for the encryption or decryption process.
     *
     * @return the key as an integer
     */
    public int getKey() {
        return key;
    }
}
