package com.cherkes.actions;


/**
 * This class extends the {@code BaseAction} abstract class and represents a decryption action.
 * It provides functionality for decrypting a given context using the Caesar cipher algorithm.
 */
public class Decrypt extends BaseAction {

    /**
     * Constructs a new {@code Decrypt} instance with the specified key for decryption.
     *
     * @param key the key used for the decryption process
     */
    public Decrypt(int key) {
        super(key);
    }

    /**
     * Overrides the {@code getKey()} method in the base class to provide the opposite key for decryption.
     *
     * @return the key for decryption as an integer
     */
    @Override
    public int getKey() {
        return (-1) * super.getKey();
    }

    /**
     * Executes the decryption process on the provided context using the specified key.
     *
     * @param context the array of characters representing the input context to be decrypted
     * @return the result of the decryption process as an array of characters
     */
    @Override
    public char[] execute(char[] context) {
        // The decryption process is handled by the execute method in the base class
        return super.execute(context);
    }
}

