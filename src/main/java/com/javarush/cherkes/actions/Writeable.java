package com.javarush.cherkes.actions;

public interface Writeable {

    /**
     * Writes the provided character data to a file specified by the given path.
     *
     * @param data the character data to be written to the file
     * @param path the path of the file to write the data into
     */
    void writeDataInFile(char[] data, String path);
}
