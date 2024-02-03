package com.javarush.cherkes;

import com.javarush.cherkes.Exceptions.InvalidDeviation;
import com.javarush.cherkes.actions.Decrypt;
import com.javarush.cherkes.actions.Encrypt;
import com.javarush.cherkes.statistic.Statistic;

import java.io.File;

public class ConsoleRunner {
    public static void main(String[] args) throws InvalidDeviation {
        Encrypt encrypt = new Encrypt();
        String path = System.getProperty("user.dir");
        char[] data = Encrypt.readDataFromFile(path + File.separator + "text" + File.separator + "text.txt");
        int key = 3;
        Encrypt.writeDataInFile(encrypt.execute(data, 3), path + File.separator + "text" + File.separator + "encrypted.txt");

        Decrypt decrypt = new Decrypt();
        char[] encryptedData = Decrypt.readDataFromFile(path + File.separator + "text" + File.separator + "encrypted.txt");
        Decrypt.writeDataInFile(decrypt.execute(encryptedData, key), path + File.separator + "text" + File.separator + "decrypted.txt");

        int[][] table1 = Statistic.collectStatistic(Encrypt.readDataFromFile(path + File.separator + "text" + File.separator + "text.txt"));
        int[][] table2 = Statistic.collectStatistic(Encrypt.readDataFromFile(path + File.separator + "text" + File.separator + "dict.txt"));

        System.out.println(Statistic.compareTables(table1, table2, 0.7));
    }
}
