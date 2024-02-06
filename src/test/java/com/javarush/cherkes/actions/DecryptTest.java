package com.javarush.cherkes.actions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DecryptTest {

    @Test
    void testExecuteWithinRangeWhenKeySmall() {
        Decrypt decrypt = new Decrypt(1);
        char[] expectedOutput = "Hello, World!".toCharArray();
        char[] input = "Ifmmp-!Xpsme\"".toCharArray();

        assertArrayEquals(expectedOutput, decrypt.execute(input));
    }

    @Test
    void testExecuteWithinRangeWhenKeyZero() {
        Decrypt decrypt = new Decrypt(0);
        char[] input = "Hello, World!".toCharArray();
        char[] expectedOutput = "Hello, World!".toCharArray();

        assertArrayEquals(expectedOutput, decrypt.execute(input));
    }

    @Test
    void testExecuteWithinRangeWhenKeyGreat() {
        Decrypt decrypt = new Decrypt(200);
        int delta = 10;
        char[] input = "Hello".toCharArray();
        char[] expectedOutput = {(char) ('H' - delta), (char) ('e' - delta), (char) ('l' - delta), (char) ('l' - delta), (char) ('o' - delta)};

        assertArrayEquals(expectedOutput, decrypt.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "93, 34, 'when sum of key and index > 32 but < 126'",
            "0, 32, 'when sum key is 0'",
            "94, 33, 'when sum of key and index is the extreme value of the range'",
            "95, 32, 'when sum of key and index is out of range'",
            "250, 67, 'when key is much greater than range'",
            "-1, 33, 'when key is negative'",
    })
    void testGetCompleteIndexForDifferKeys(int key, int expected, String description) {
        Decrypt encrypt = new Decrypt(key);
        int result = encrypt.getCompleteIndex(32);
        assertEquals(expected, result, description);
    }
}