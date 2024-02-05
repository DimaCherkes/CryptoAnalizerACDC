package com.javarush.cherkes.actions;

import com.javarush.cherkes.constants.StaticSymbols;
import com.javarush.cherkes.io.IOData;
import com.javarush.cherkes.statistic.Statistic;


public class BruteForce {
    private static final IOData ioData = new IOData();

    private BruteForce(){

    }

    public static boolean execute(char[] context, String dictPath, String decryptedPath) {
        char[] forAnalyze = ioData.readDataFromFile(dictPath);
        int[][] dictionaryTable = Statistic.collectStatistic(forAnalyze);

        for (int key = 0; key < StaticSymbols.NUMBER_OF_CHARACTERS; key++) {
            BaseAction decrypt = new Decrypt(key);
            char[] attemptToDecrypt = decrypt.execute(context);
            int[][] attemptToDecryptTable = Statistic.collectStatistic(attemptToDecrypt);

            if (Statistic.compareTables(dictionaryTable, attemptToDecryptTable)){
                ioData.writeDataInFile(attemptToDecrypt, decryptedPath);
                return true;
            }
        }
        return false;
    }
}
