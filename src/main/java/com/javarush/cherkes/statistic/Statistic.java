package com.javarush.cherkes.statistic;

/*
 * analyze common text to collect data
 * with this class you understand is this text encoded or no
 */


import com.javarush.cherkes.constants.StaticSymbols;

/**
 * The Statistic class is responsible for analyzing common text to collect data. It helps determine whether the text is encoded.
 * This class provides methods for collecting statistical data and comparing tables of frequencies between two datasets.
 */
public class Statistic {

    /**
     * Private constructor to prevent instantiation as the class consists of static methods.
     */
    private Statistic() {
    }

    /**
     * Collects statistical data from the input text, analyzing the occurrences of character pairs.
     *
     * @param data the input text in the form of a character array
     * @return a 2D array representing the frequency of character pairs
     */
    public static int[][] collectStatistic(char[] data) {
        // Number of unique characters in the ASCII table
        int count = StaticSymbols.NUMBER_OF_CHARACTERS;
        // The starting point of ASCII values for characters
        int delta = StaticSymbols.DOWN_INDEX_OF_ASCII;
        // 2D array to store the frequency of character pairs
        int[][] table = new int[count][count];

        // Iterate through the input text to collect statistical data
        for (int i = 0; i < data.length - 1; i++) {
            char thisChar = data[i];
            char nextChar = data[i + 1];
            int indexOfThisChar;
            int indexOfNextChar;

            try {
                // Convert characters to indices in the ASCII table
                indexOfThisChar = StaticSymbols.getIndexByCharacter(thisChar) - delta;
                indexOfNextChar = StaticSymbols.getIndexByCharacter(nextChar) - delta;
            } catch (NullPointerException e) {
                // Skip characters that are not in the maintained ASCII table
                continue;
            }

            // Increment the count for the corresponding character pair
            table[indexOfThisChar][indexOfNextChar]++;
        }
        return table;
    }

    /**
     * Compares two tables of frequencies to determine the similarity between the datasets.
     *
     * @param table1 the first table of frequencies
     * @param table2 the second table of frequencies
     * @return true if there is a significant similarity between the two tables, false otherwise
     * @implSpec The statistical feature I found is that if the text does not look like the text a person is used to,
     * then its values in the 2D array will be in a different corner and the overlap of values is greatly reduced.
     */
    public static boolean compareTables(int[][] table1, int[][] table2) {
        int bothAreNotZero = 0;
        int oneIsNotZero = 0;

        // Iterate through each element in the tables
        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[0].length; j++) {
                if (table1[i][j] != 0 && table2[i][j] != 0) {
                    // Both tables have non-zero frequencies for this character pair
                    bothAreNotZero++;
                } else if ((table1[i][j] == 0 && table2[i][j] != 0) ||
                        (table1[i][j] != 0 && table2[i][j] == 0)) {
                    // Only one of the tables has non-zero frequency for this character pair
                    oneIsNotZero++;
                }
            }
        }
        // Calculate the ratio of both tables having non-zero frequencies to only one having non-zero frequency
        double relations = (double) bothAreNotZero / oneIsNotZero;

        // Determine if there is a significant similarity based on the ratio
        return relations > 1;
    }
}

