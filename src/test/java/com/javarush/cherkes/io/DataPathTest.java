package com.javarush.cherkes.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DataPathTest {

    @Test
    void testConstructorWithCustomPathsAndKey() {
        // Test the constructor with custom paths and key for decryption mode
        String customSource = "custom" + File.separator + "source.txt";
        String customDestination = "custom" + File.separator + "decrypted.txt";
        int customKey = 123;

        System.setIn(new ByteArrayInputStream(String.format("%s%n%s%n%d%n", customSource, customDestination, customKey).getBytes()));
        DataPath dataPath = new DataPath(2);

        assertAll(
                () -> assertEquals(customSource, dataPath.getSource()),
                () -> assertEquals(customDestination, dataPath.getDestination()),
                () -> assertEquals(customKey, dataPath.getKey()),
                () -> assertEquals(System.getProperty("user.dir") + File.separator + "text" + File.separator + "dict.txt", dataPath.getDictPath())); // Dictionary path should still be standard
        System.setIn(System.in);
    }
}