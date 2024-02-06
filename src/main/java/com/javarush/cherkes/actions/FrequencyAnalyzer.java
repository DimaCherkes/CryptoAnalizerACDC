package com.javarush.cherkes.actions;

import com.javarush.cherkes.constants.StaticSymbols;

import java.util.*;

/**
 * The FrequencyAnalyzer class provides methods to decrypt a given encrypted text using a common English text.
 * The decryption process is based on substitution cipher, where characters in the encrypted text are replaced with characters
 * from the common English text based on their frequencies.
 *
 * @implSpec Since encryption supports a large range of characters - {@value StaticSymbols#NUMBER_OF_CHARACTERS},
 * this mode requires additional analysis after its operation. As the amount of text increases, the accuracy should increase.
 */

public class FrequencyAnalyzer {
    private FrequencyAnalyzer() {

    }

    /**
     * Calculates the frequencies of characters in the given text, excluding '\n' and '\r' characters.
     *
     * @param text the input text
     * @return a map containing characters as keys and their frequencies as values
     */
    public static Map<Character, Integer> calculateCharacterFrequencies(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (c != '\n' && c != '\r' && StaticSymbols.allCharacters.containsKey(c)) {
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
    public static char[] execute(String encryptedText, String commonEnglishText) {
        Map<Character, Character> substitutionMap = buildSubstitutionMap(encryptedText, commonEnglishText);

        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
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
     * @param encryptedText      the input encrypted text
     * @param commonEnglishText  the common English text
     * @return a map containing characters from the encrypted text as keys and characters from the common English text as values
     */
    public static Map<Character, Character> buildSubstitutionMap(String encryptedText, String commonEnglishText) {
        // Calculate the frequencies of characters in the encrypted and common English texts
        Map<Character, Integer> encryptedFrequencies = calculateCharacterFrequencies(encryptedText);
        Map<Character, Integer> commonFrequencies = calculateCharacterFrequencies(commonEnglishText);

        // Convert frequencies into lists for sorting
        List<Map.Entry<Character, Integer>> encryptedFrequencyList = new ArrayList<>(encryptedFrequencies.entrySet());
        List<Map.Entry<Character, Integer>> commonFrequencyList = new ArrayList<>(commonFrequencies.entrySet());

        // Sort the frequency lists in descending order based on character frequencies
        Collections.sort(encryptedFrequencyList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        Collections.sort(commonFrequencyList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        // Build the substitution map
        Map<Character, Character> substitutionMap = new HashMap<>();
        for (int i = 0; i < encryptedFrequencyList.size(); i++) {
            try {
                char a = encryptedFrequencyList.get(i).getKey();
                char b = commonFrequencyList.get(i).getKey();
                substitutionMap.put(a, b);
            } catch (Exception e) {
                break; // Handle potential index out of bounds exception
            }
        }

        return substitutionMap;
    }


}