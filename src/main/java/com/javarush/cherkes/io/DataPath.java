package com.javarush.cherkes.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataPath {
    private final String textPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "text.txt";
    private final String dictPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "dict.txt";
    private final String encryptedPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "encrypted.txt";
    private final String decryptedPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "decrypted.txt";
    private String source;
    private String destination;
    private int key;

    public DataPath(int mode) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Write source file or press Enter to use standard path: ");
            source = reader.readLine();
            if (source.isEmpty()) {
                switch (mode) {
                    case 1 :
                        source = textPath;
                        break;
                    case 2, 3, 4:
                        source = encryptedPath;
                        break;
                }
            }

            System.out.println("Write destination file or press Enter to use standard path: ");
            destination = reader.readLine();
            if (destination.isEmpty()) {
                switch (mode) {
                    case 1 :
                        destination = encryptedPath;
                        break;
                    case 2, 3, 4:
                        destination = decryptedPath;
                        break;
                }
            }

            if (mode == 1 || mode == 2) {
                System.out.print("Write key: ");
                key = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getKey() {
        return key;
    }

    public String getDictPath() {
        return dictPath;
    }
}
