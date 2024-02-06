package com.cherkes.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class providing file paths and encryption/decryption key.
 * Allows users to input custom paths and a key based on the specified mode.
 */
public class DataPath {

    // Constants for standard paths
    private final String textPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "text.txt";
    private final String dictPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "dict.txt";
    private final String encryptedPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "encrypted.txt";
    private final String decryptedPath = System.getProperty("user.dir") + File.separator + "text" + File.separator + "decrypted.txt";

    // Variables for user-defined paths and key
    private String source;
    private String destination;
    private int key;

    /**
     * Constructs a new DataPath instance based on the specified mode.
     *
     * @param mode The execution mode (1 - encryption, 2-4 - decryption)
     */
    public DataPath(int mode) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // User-defined source path assignment
            System.out.println("Write source file or press Enter to use the standard path: ");
            source = reader.readLine();
            if (source.isBlank()) {
                switch (mode) {
                    case 1:
                        source = textPath;
                        break;
                    case 2, 3, 4:
                        source = encryptedPath;
                        break;
                }
            }

            // User-defined destination path assignment
            System.out.println("Write the destination file or press Enter to use the standard path: ");
            destination = reader.readLine();
            if (destination.isBlank()) {
                switch (mode) {
                    case 1:
                        destination = encryptedPath;
                        break;
                    case 2, 3, 4:
                        destination = decryptedPath;
                        break;
                }
            }

            // Key assignment in modes 1 and 2
            if (mode == 1 || mode == 2) {
                System.out.print("Write the key: ");
                key = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the source file path.
     *
     * @return The source file path.
     */
    public String getSource() {
        return source;
    }

    /**
     * Gets the destination file path.
     *
     * @return The destination file path.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Gets the encryption/decryption key.
     *
     * @return The encryption/decryption key.
     */
    public int getKey() {
        return key;
    }

    /**
     * Gets the dictionary file path.
     *
     * @return The dictionary file path.
     */
    public String getDictPath() {
        return dictPath;
    }
}

