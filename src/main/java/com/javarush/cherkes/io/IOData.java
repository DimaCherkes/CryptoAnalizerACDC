package com.javarush.cherkes.io;

import com.javarush.cherkes.actions.Readable;
import com.javarush.cherkes.actions.Writeable;

import java.io.*;

public class IOData implements Readable, Writeable {

    public char[] readDataFromFile(String path) {
        StringBuilder data = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                data.append((char) reader.read());
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString().toCharArray();
    }

    public void writeDataInFile(char[] data, String path) {
        File file = new File(path);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
