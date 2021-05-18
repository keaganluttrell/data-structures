package com.dsags.sorts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    int[] numbers;
    int[] sorted;

    @BeforeEach
    void setup() {
        numbers = new int[]{4, 5, 8, 2, 9, 3, 6, 1, 7};
        sorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    void quicksort_shouldExist() {
        Sort.quicksort(numbers);
    }

    @Test
    void quicksort_UnsortedArray_SortsArray() {
        Sort.quicksort(numbers);
        assertArrayEquals(sorted, numbers);
    }

    @Test
    void quicksort_SortedArray_StillBeSorted() {
        int[] sorted2 = new int[sorted.length];
        System.arraycopy(sorted, 0, sorted2, 0, sorted.length);
        Sort.quicksort(sorted2);
        assertArrayEquals(sorted, sorted2);
    }
}
