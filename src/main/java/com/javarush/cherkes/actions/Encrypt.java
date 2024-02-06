package com.javarush.cherkes.actions;


/**
 * This class extends the {@code BaseAction} abstract class and represents an encryption action.
 * It provides functionality for encrypting a given context using the Caesar cipher algorithm.
 */
public class Encrypt extends BaseAction {

    /**
     * Constructs a new {@code Encrypt} instance with the specified key for encryption.
     *
     * @param key the key used for the encryption process
     */
    public Encrypt(int key) {
        super(key);
    }

    /**
     * Executes the encryption process on the provided context using the specified key.
     *
     * @param context the array of characters representing the input context to be encrypted
     * @return the result of the encryption process as an array of characters
     */
    @Override
    public char[] execute(char[] context) {
        // The encryption process is handled by the execute method in the base class
        return super.execute(context);
    }
}

