package com.cherkes.constants;

import java.util.HashMap;
import java.util.Map;

/**
     * The class containing static symbols and utility methods related to ASCII characters.
 */
public class StaticSymbols {

    /**
     * The mapping of characters to their ASCII indices.
     */
    public static final Map<Character, Integer> allCharacters = fillDictionary();

    /**
     * The lower index of ASCII characters.
     */
    public static final int DOWN_INDEX_OF_ASCII = 32;

    /**
     * The upper index of ASCII characters.
     */
    public static final int UPPER_INDEX_OF_ASCII = 126;

    /**
     * The total number of ASCII characters.
     */
    public static final int NUMBER_OF_CHARACTERS = UPPER_INDEX_OF_ASCII - DOWN_INDEX_OF_ASCII + 1;

    /**
     * Fills a dictionary with characters and their corresponding ASCII indices.
     *
     * @return the filled dictionary
     */
    private static Map<Character, Integer> fillDictionary() {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = DOWN_INDEX_OF_ASCII; i <= UPPER_INDEX_OF_ASCII; i++) {
            dictionary.put((char) i, i);
        }
        return dictionary;
    }

    /**
     * Retrieves the ASCII index of a given character.
     *
     * @param ch the character
     * @return the ASCII index of the character
     */
    public static int getIndexByCharacter(char ch) {
        return allCharacters.get(ch);
    }

    /**
     * Retrieves the character based on its ASCII index.
     *
     * @param index the ASCII index
     * @return the character corresponding to the index
     */
    public static char getCharByIndex(int index) {
        for (Map.Entry<Character, Integer> pair : allCharacters.entrySet()) {
            if (pair.getValue() == index) {
                return pair.getKey();
            }
        }
        return '\n'; // Default return value if not found
    }
}

