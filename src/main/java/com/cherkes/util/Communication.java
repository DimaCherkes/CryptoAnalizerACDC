package com.cherkes.util;

import com.cherkes.actions.BruteForce;
import com.cherkes.actions.Decrypt;
import com.cherkes.actions.Encrypt;
import com.cherkes.actions.FrequencyAnalyser;
import com.cherkes.io.DataPath;
import com.cherkes.io.IOData;

import java.util.Scanner;

/**
 * This class handles communication with the user and initiates the corresponding encryption, decryption,
 * brute-force, or analysis operations based on user input.
 * The user is presented with a menu to choose the desired mode of operation.
 */
public class Communication {

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private Communication() {
    }

    /**
     * Starts the communication and mode selection with the user.
     */
    public static void start() {
        printMenu();
        int mode = handlingUsersInput();
        modeLaunch(mode);
    }

    /**
     * Prints the menu options for the user to select a mode of operation.
     */
    private static void printMenu() {
        System.out.println("Select a mode by entering the number: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. BruteForce");
        System.out.println("4. Analyze");
        System.out.println("5. Exit");
    }

    /**
     * Handles user input to select a mode.
     *
     * @return the selected mode
     */
    private static int handlingUsersInput() {
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }

    /**
     * Launches the corresponding mode of operation based on the user's selection.
     *
     * @param mode the selected mode of operation
     */
    private static void modeLaunch(int mode) {
        DataPath dataPath = new DataPath(mode);
        IOData ioData = new IOData();
        switch (mode) {
            case 1:
                Encrypt encrypt = new Encrypt(dataPath.getKey());
                char[] unencrypted = ioData.readDataFromFile(dataPath.getSource());
                ioData.writeDataInFile(encrypt.execute(unencrypted), dataPath.getDestination());
                break;
            case 2:
                Decrypt decrypt = new Decrypt(dataPath.getKey());
                char[] encrypted = ioData.readDataFromFile(dataPath.getSource());
                ioData.writeDataInFile(decrypt.execute(encrypted), dataPath.getDestination());
                break;
            case 3:
                char[] dataToBruteForce = ioData.readDataFromFile(dataPath.getSource());
                BruteForce.execute(dataToBruteForce, dataPath.getDictPath(), dataPath.getDestination());
                break;
            case 4:
                String dataToAnalyze = new String(ioData.readDataFromFile(dataPath.getSource()));
                String dict = new String(ioData.readDataFromFile(dataPath.getDictPath()));
                char[] decrypted = FrequencyAnalyser.execute(dataToAnalyze, dict);
                ioData.writeDataInFile(decrypted, dataPath.getDestination());
                break;
            case 5:
                break;
        }
    }
}

