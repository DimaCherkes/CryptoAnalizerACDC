package com.javarush.cherkes;

import com.javarush.cherkes.util.Communication;

public class ConsoleRunner {
    public static void main(String[] args) {

        Communication.start();


//        String path = System.getProperty("user.dir");
//        char[] data = Encrypt.readDataFromFile(path + File.separator + "text" + File.separator + "text.txt");
//        char[] dict = Encrypt.readDataFromFile(path + File.separator + "text" + File.separator + "dict.txt");
//
//        int key = 40;
//        char[] encryptedData = Encrypt.execute(data, key);
//        char[] decrypted = SubstitutionDecrypter.execute(encryptedData, dict);
//
//        Decrypt.writeDataInFile(decrypted, path + File.separator + "text" + File.separator + "decrypted.txt");

        //char[] decryptedData = Decrypt.readDataFromFile(path + File.separator + "text" + File.separator + "encrypted.txt");
        //Decrypt.writeDataInFile(Decrypt.execute(encryptedData, key), path + File.separator + "text" + File.separator + "decrypted.txt");

//        Analyze.execute(dict, data);
//        Analyze.writeDataInFile(data, path + File.separator + "text" + File.separator + "decrypted.txt");

//        Date start = new Date();
//        for (int key = 0; key < StaticSymbols.NUMBER_OF_CHARACTERS; key++) {
//            char[] encryptedData = Encrypt.execute(data, key);
//            System.out.println(key + ": " + BruteForce.execute(encryptedData));
//        }
//        Date finish = new Date();
//        System.out.println(finish.getTime() - start.getTime());

    }
}
