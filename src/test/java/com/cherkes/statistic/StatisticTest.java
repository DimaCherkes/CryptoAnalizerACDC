package com.cherkes.statistic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatisticTest {

    @Test
    void testCollectStatistic() {
        // Test the collection of statistical data for a simple input
        char[] input = "ababab".toCharArray();
        int[][] result = Statistic.collectStatistic(input);

        // Validate the result based on the known input
        assertEquals(3, result['a' - 32]['b' - 32]); // 'a' to 'b' frequency
        assertEquals(2, result['b' - 32]['a' - 32]); // 'b' to 'a' frequency
    }

    @Test
    void testCompareTables_SimilarTables() {
        // Test the comparison of similar tables
        int[][] table1 = {
                {1, 2},
                {3, 4}
        };
        int[][] table2 = {
                {1, 2},
                {3, 4}
        };

        // Validate that similar tables are identified as similar
        assertTrue(Statistic.compareTables(table1, table2));
    }

    @Test
    void testCompareTables_DissimilarTables() {
        // Test the comparison of dissimilar tables
        int[][] table1 = {
                {0, 2},
                {3, 0}
        };
        int[][] table2 = {
                {5, 6},
                {7, 8}
        };

        // Validate that dissimilar tables are identified as dissimilar
        assertFalse(Statistic.compareTables(table1, table2));
    }

}
