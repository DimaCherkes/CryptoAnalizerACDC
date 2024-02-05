package com.javarush.cherkes.util;

import com.javarush.cherkes.actions.BruteForce;
import com.javarush.cherkes.actions.Decrypt;
import com.javarush.cherkes.actions.Encrypt;
import com.javarush.cherkes.actions.SubstitutionDecrypter;
import com.javarush.cherkes.io.DataPath;
import com.javarush.cherkes.io.IOData;

import java.util.Scanner;

public class Communication {

    private Communication(){

    }

    public static void start() {
        printMenu();
        int mode = handlingUsersInput();
        modeLaunch(mode);
    }

    private static void printMenu() {
        System.out.println("Select a mode by entering the number: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. BruteForce");
        System.out.println("4. Analyze");
        System.out.println("5. Exit");
    }

    private static int handlingUsersInput() {
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }

    private static void modeLaunch(int mode) {
        DataPath dataPath = new DataPath(mode);
        IOData ioData = new IOData();
        switch (mode ) {
            case 1 :
                Encrypt encrypt = new Encrypt(dataPath.getKey());
                char[] unencrypted = ioData.readDataFromFile(dataPath.getSource());
                ioData.writeDataInFile(encrypt.execute(unencrypted), dataPath.getDestination());
                break;
            case 2 :
                Decrypt decrypt = new Decrypt(dataPath.getKey());
                char[] encrypted = ioData.readDataFromFile(dataPath.getSource());
                ioData.writeDataInFile(decrypt.execute(encrypted), dataPath.getDestination());
                break;
            case 3 :
                char[] dataToBruteForce = ioData.readDataFromFile(dataPath.getSource());
                BruteForce.execute(dataToBruteForce, dataPath.getDictPath(), dataPath.getDestination());
                break;
            case 4 :
                char[] dataToAnalyze = ioData.readDataFromFile(dataPath.getSource());
                char[] dict = ioData.readDataFromFile(dataPath.getDictPath());
                char[] decrypted = SubstitutionDecrypter.execute(dataToAnalyze, dict);
                ioData.writeDataInFile(decrypted, dataPath.getDestination());
                break;
            case 5 :
                break;
        }
    }

}
