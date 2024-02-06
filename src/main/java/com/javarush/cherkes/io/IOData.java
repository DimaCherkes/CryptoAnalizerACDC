package com.javarush.cherkes.io;

import com.javarush.cherkes.actions.Readable;
import com.javarush.cherkes.actions.Writeable;

import java.io.*;

/**
 * This class provides functionality for reading data from a file and writing data to a file.
 * It implements the {@code Readable} and {@code Writeable} interfaces to ensure consistent behavior.
 */
public class IOData implements Readable, Writeable {

    /**
     * Reads data from the specified file path and returns it as an array of characters.
     *
     * @param path the path of the file to read data from
     * @return an array of characters representing the data read from the file
     */
    @Override
    public char[] readDataFromFile(String path) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                data.append((char) reader.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString().toCharArray();
    }

    /**
     * Writes the provided data to the specified file path.
     *
     * @param data the array of characters representing the data to be written
     * @param path the path of the file to write data to
     */
    @Override
    public void writeDataInFile(char[] data, String path) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

