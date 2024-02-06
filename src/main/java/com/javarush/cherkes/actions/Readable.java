package com.javarush.cherkes.actions;

public interface Readable {

    /**
     * Reads character data from a file specified by the given path.
     *
     * @param path the path of the file from which to read character data
     * @return an array of characters containing the data read from the file
     */
    char[] readDataFromFile(String path);
}
