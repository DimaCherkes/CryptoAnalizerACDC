package com.cherkes.actions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Map;

class FrequencyAnalyserTest {

    @Test
    void testBuildSubstitutionMap_SimpleCase() {
        // Test the substitution map for a simple case
        String encryptedText = "HfsfHH";
        String commonEnglishText = "TTThhe";
        Map<Character, Character> substitutionMap = FrequencyAnalyser.buildSubstitutionMap(encryptedText, commonEnglishText);

        // Validate the substitution map for each character
        assertEquals('T', substitutionMap.get('H'));
        assertEquals('h', substitutionMap.get('f'));
        assertEquals('e', substitutionMap.get('s'));
    }

    @Test
    void testBuildSubstitutionMap_WithSpecialCharacters() {
        // Test the substitution map with special characters
        String encryptedText = "HHHHfffss!";
        String commonEnglishText = "TTTThhhee!";
        Map<Character, Character> substitutionMap = FrequencyAnalyser.buildSubstitutionMap(encryptedText, commonEnglishText);

        // Validate the substitution map for each character, including special characters
        assertEquals('T', substitutionMap.get('H'));
        assertEquals('h', substitutionMap.get('f'));
        assertEquals('e', substitutionMap.get('s'));
        assertEquals('!', substitutionMap.get('!'));
    }

    @Test
    void testBuildSubstitutionMap_EmptyCommonEnglishText() {
        // Test the substitution map with an empty common English text
        String encryptedText = "Hfs cpnf";
        String commonEnglishText = "";
        Map<Character, Character> substitutionMap = FrequencyAnalyser.buildSubstitutionMap(encryptedText, commonEnglishText);

        // Validate that the substitution map is empty
        assertTrue(substitutionMap.isEmpty());
    }

    @Test
    void testBuildSubstitutionMap_EmptyEncryptedText() {
        // Test the substitution map with an empty encrypted text
        String encryptedText = "";
        String commonEnglishText = "The quick";
        Map<Character, Character> substitutionMap = FrequencyAnalyser.buildSubstitutionMap(encryptedText, commonEnglishText);

        // Validate that the substitution map is empty
        assertTrue(substitutionMap.isEmpty());
    }
}
