package com.javarush.cherkes.statistic;

/*
 * analyze common text to collect data
 * with this class you understand is this text encoded or no
 */


import com.javarush.cherkes.constants.StaticSymbols;

public class Statistic {

    private Statistic(){

    }

    public static int[][] collectStatistic(char[] data) {
        int count = StaticSymbols.NUMBER_OF_CHARACTERS;
        int delta = StaticSymbols.DOWN_INDEX_OF_ASCII;
        int[][] table = new int[count][count];

        for (int i = 0; i < data.length - 1; i++) {
            char thisChar = data[i];
            char nextChar = data[i+1];
            int indexOfThisChar;
            int indexOfNextChar;
            try {
                indexOfThisChar = StaticSymbols.getIndexByCharacter(thisChar) - delta;
                indexOfNextChar = StaticSymbols.getIndexByCharacter(nextChar) - delta;
            } catch (NullPointerException e) {
                continue;
            }

            table[indexOfThisChar][indexOfNextChar]++;
        }
        return table;
    }

    public static boolean compareTables(int[][] table1, int[][] table2) {

        int bothAreNotZero = 0;
        int oneIsNotZero = 0;
        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[0].length; j++) {
                if (table1[i][j] != 0 && table2[i][j] != 0) {
                    bothAreNotZero++;
                } else if ((table1[i][j] == 0 && table2[i][j] != 0) ||
                        ((table1[i][j] != 0 && table2[i][j] == 0))){
                    oneIsNotZero++;
                }
            }
        }
        double relations = (double) bothAreNotZero / oneIsNotZero;

        return 1 < relations;
    }

}
