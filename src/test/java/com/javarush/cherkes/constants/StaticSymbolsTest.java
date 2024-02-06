package com.javarush.cherkes.constants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StaticSymbolsTest {

    @Test
    void testGetCharByIndex_ValidIndex() {
        // Test when a valid index is provided
        char result = StaticSymbols.getCharByIndex(65); // ASCII index of 'A'

        // Validate that the correct character is retrieved
        assertEquals('A', result);
    }

    @Test
    void testGetCharByIndex_InvalidIndex() {
        // Test when an invalid index is provided
        char result = StaticSymbols.getCharByIndex(200); // An index outside the valid range

        // Validate that the default return value is used
        assertEquals('\n', result);
    }

    @Test
    void testGetCharByIndex_FirstCharacter() {
        // Test when the index corresponds to the first character
        char result = StaticSymbols.getCharByIndex(StaticSymbols.DOWN_INDEX_OF_ASCII);

        // Validate that the correct character is retrieved
        assertEquals((char) StaticSymbols.DOWN_INDEX_OF_ASCII, result);
    }

    @Test
    void testGetCharByIndex_LastCharacter() {
        // Test when the index corresponds to the last character
        char result = StaticSymbols.getCharByIndex(StaticSymbols.UPPER_INDEX_OF_ASCII);

        // Validate that the correct character is retrieved
        assertEquals((char) StaticSymbols.UPPER_INDEX_OF_ASCII, result);
    }
}