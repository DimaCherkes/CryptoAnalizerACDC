package com.cherkes.actions;

import com.cherkes.constants.StaticSymbols;
import com.cherkes.io.IOData;
import com.cherkes.statistic.Statistic;


/**
 * This class provides functionality for brute force decryption of a given context using statistical analysis.
 * It attempts to decrypt the context by trying all possible keys and comparing the frequency tables
 * of the decrypted text with a pre-analyzed dictionary.
 */
public class BruteForce {

    /**
     * An instance of the {@code IOData} class for reading data from files and writing data to files.
     */
    private static final IOData ioData = new IOData();

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private BruteForce() {
    }

    /**
     * Executes the brute force decryption process on the provided context using a pre-analyzed dictionary.
     * Tries all possible keys and compares the frequency tables of the decrypted text with the dictionary.
     * If a match is found, the decrypted text is written to the specified file path.
     *
     * @param context        the array of characters representing the encrypted text to be decrypted
     * @param dictPath       the file path to the pre-analyzed dictionary
     * @param decryptedPath  the file path where the decrypted text will be written if a match is found
     * @return {@code true} if the decryption is successful, {@code false} otherwise
     */
    public static boolean execute(char[] context, String dictPath, String decryptedPath) {
        char[] forAnalyze = ioData.readDataFromFile(dictPath);
        int[][] dictionaryTable = Statistic.collectStatistic(forAnalyze);

        for (int key = 0; key < StaticSymbols.NUMBER_OF_CHARACTERS; key++) {
            BaseAction decrypt = new Decrypt(key);
            char[] attemptToDecrypt = decrypt.execute(context);
            int[][] attemptToDecryptTable = Statistic.collectStatistic(attemptToDecrypt);

            if (Statistic.compareTables(dictionaryTable, attemptToDecryptTable)) {
                ioData.writeDataInFile(attemptToDecrypt, decryptedPath);
                return true;
            }
        }
        return false;
    }
}

