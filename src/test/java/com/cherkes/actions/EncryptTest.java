package com.cherkes.actions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EncryptTest {

    @Test
    void testExecuteWithinRangeWhenKeySmall() {
        Encrypt encryptor = new Encrypt(1);
        char[] input = "Hello, World!".toCharArray();
        char[] expectedOutput = "Ifmmp-!Xpsme\"".toCharArray();

        assertArrayEquals(expectedOutput, encryptor.execute(input));
    }

    @Test
    void testExecuteWithinRangeWhenKeyZero() {
        Encrypt encryptor = new Encrypt(0);
        char[] input = "Hello, World!".toCharArray();
        char[] expectedOutput = "Hello, World!".toCharArray();

        assertArrayEquals(expectedOutput, encryptor.execute(input));
    }

    @Test
    void testExecuteWithinRangeWhenKeyGreat() {
        Encrypt encryptor = new Encrypt(200);
        int delta = 10;
        char[] input = "Hello".toCharArray();
        char[] expectedOutput = {(char) ('H' + delta), (char) ('e' + delta), (char) ('l' + delta), (char) ('l' + delta), (char) ('o' + delta)};

        assertArrayEquals(expectedOutput, encryptor.execute(input));
    }


    @ParameterizedTest
    @CsvSource({
            "93, 125, 'when sum of key and index > 32 but < 126'",
            "0, 32, 'when sum key is 0'",
            "94, 126, 'when sum of key and index is the extreme value of the range'",
            "95, 32, 'when sum of key and index is out of range'",
            "250, 92, 'when key is much greater than range'",
            "-1, 126, 'when key is negative'",
    })
    void testGetCompleteIndexForDifferKeys(int key, int expected, String description) {
        Encrypt encrypt = new Encrypt(key);
        int result = encrypt.getCompleteIndex(32);
        assertEquals(expected, result, description);
    }




}