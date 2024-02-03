package com.javarush.cherkes.statistic;

/*
 * analyze common text to collect data
 * with this class you understand is this text encoded or no
 */


import com.javarush.cherkes.Exceptions.InvalidDeviation;
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

    public static boolean compareTables(int[][] table1, int[][] table2, double acceptableDeviation) throws InvalidDeviation {
        if (acceptableDeviation > 1 || acceptableDeviation < 0) {
            throw new InvalidDeviation();
        }
        double[] attitude = new double[table1.length * table1.length];
        int index = 0;
        int counterForZero = 0;
        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[0].length; j++) {
                if (table1[i][j] == 0 || table2[i][j] == 0) {
                    counterForZero++;
                    index++;
                    continue;
                }
                attitude[index] = (double) table1[i][j] / table2[i][j];
                index++;
            }
        }
        double sum = 0;
        for (double v : attitude) {
            sum += v;
        }

        double averageValue = sum / (attitude.length - counterForZero);

        int counter = 0;
        int sufficientAmount = (int) ((attitude.length - counterForZero) * acceptableDeviation);
        for (int i = 0; i < attitude.length; i++) {
            if (isWithinPercentageDifference(attitude[i], averageValue, 1 - acceptableDeviation)) {
                counter+=1;
            }
            if (counter >= sufficientAmount) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWithinPercentageDifference(double number1, double number2, double maxPercentageDifference) {
        if (number1 == 0 && number2 == 0) {
            // Обрабатываем случай, когда оба числа равны нулю
            return true;
        }

        // Рассчитываем процентное отличие
        double percentageDifference = Math.abs((number1 - number2) / number1);

        // Проверяем, что процентное отличие не превышает заданный порог
        return percentageDifference <= maxPercentageDifference;
    }

}
