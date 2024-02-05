package com.javarush.cherkes.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StaticSymbols {

    private static Map<Character, Integer> allCharacters = fillDictionary();
    public static final int DOWN_INDEX_OF_ASCII = 32;
    public static final int UPPER_INDEX_OF_ASCII = 126;
    public static final int NUMBER_OF_CHARACTERS = UPPER_INDEX_OF_ASCII - DOWN_INDEX_OF_ASCII + 1;

    private static Map<Character, Integer> fillDictionary() {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = DOWN_INDEX_OF_ASCII; i <= UPPER_INDEX_OF_ASCII; i++) {
            dictionary.put((char) i, i);
        }
        return dictionary;
    }

    public static Map<Character, Integer> getAllCharacters() {
        return allCharacters;
    }

    public static int getIndexByCharacter(char ch) {
        return allCharacters.get(ch);
    }

    // return symbol by index from ascii table
    public static char getCharByIndex(int index) {
        for(Map.Entry<Character, Integer> pair : allCharacters.entrySet()) {
            if (pair.getValue() == index) {
                return pair.getKey();
            }
        }
        return '\n';
    }


}
