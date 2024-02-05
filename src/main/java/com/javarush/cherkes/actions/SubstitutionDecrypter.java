package com.javarush.cherkes.actions;

import java.util.*;

/**
 * The SubstitutionDecrypter class provides methods to decrypt a given encrypted text using a common English text.
 * The decryption process is based on substitution cipher, where characters in the encrypted text are replaced with characters
 * from the common English text based on their frequencies.
 */

public class SubstitutionDecrypter {
    private SubstitutionDecrypter() {

    }

    /**
     * Calculates the frequencies of characters in the given text, excluding '\n' and '\r' characters.
     *
     * @param text the input text
     * @return a map containing characters as keys and their frequencies as values
     */
    public static Map<Character, Integer> calculateCharacterFrequencies(char[] text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : text) {
            if (c != '\n' && c != '\r') {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
        }
        return frequencies;
    }

    /**
     * Decrypts the given encrypted text using the common English text and the buildSubstitutionMap method.
     *
     * @param encryptedText the input encrypted text
     * @param commonEnglishText the common English text
     * @return the decrypted text
     */
    public static char[] execute(char[] encryptedText, char[] commonEnglishText) {
        Map<Character, Character> substitutionMap = buildSubstitutionMap(encryptedText, commonEnglishText);

        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText) {
            if (c != '\n' && c != '\r') {
                decryptedText.append(substitutionMap.getOrDefault(c, c));
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString().toCharArray();
    }

    /**
     * Builds a substitution map based on the frequencies of characters in the encrypted text and the common English text.
     * Characters in the encrypted text are replaced with characters from the common English text based on their frequencies.
     * Characters such as '\n' and '\r' are skipped and left unchanged in the decrypted text.
     *
     * @param encryptedText the input encrypted text
     * @param commonEnglishText the common English text
     * @return a map containing characters from the encrypted text as keys and characters from the common English text as values
     */
    private static Map<Character, Character> buildSubstitutionMap(char[] encryptedText, char[] commonEnglishText) {
        Map<Character, Integer> encryptedFrequencies = calculateCharacterFrequencies(encryptedText);
        Map<Character, Integer> commonFrequencies = calculateCharacterFrequencies(commonEnglishText);

        List<Map.Entry<Character, Integer>> encryptedFrequencyList = new ArrayList<>(encryptedFrequencies.entrySet());
        List<Map.Entry<Character, Integer>> commonFrequencyList = new ArrayList<>(commonFrequencies.entrySet());

        Collections.sort(encryptedFrequencyList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        Collections.sort(commonFrequencyList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        Map<Character, Character> substitutionMap = new HashMap<>();
        for (int i = 0; i < encryptedFrequencyList.size(); i++) {
            char a = encryptedFrequencyList.get(i).getKey();
            char b = commonFrequencyList.get(i).getKey();
            substitutionMap.put(a, b);
        }

        return substitutionMap;
    }

}