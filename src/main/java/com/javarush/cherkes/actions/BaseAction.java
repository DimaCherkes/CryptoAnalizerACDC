package com.javarush.cherkes.actions;

import java.io.*;

public abstract class BaseAction {

    public abstract char[] execute(char[] context, int index);

    public static char[] readDataFromFile(String path) {
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

    public static void writeDataInFile(char[] data, String path) {
        File file = new File(path);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
