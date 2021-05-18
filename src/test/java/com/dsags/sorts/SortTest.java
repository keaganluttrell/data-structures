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
    void quicksort_null_exception() {
        assertThrows(NullPointerException.class, () -> Sort.quicksort(null));
    }

    @Test
    void quicksort_emptyArray_exception() {
        EmptyArrayException e = assertThrows(EmptyArrayException.class, () -> Sort.quicksort(new int[0]));
        assertEquals("Cannot sort empty array", e.getMessage());
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

    @Test
    void bubbleSort_shouldExist() {
        Sort.bubbleSort(numbers);
    }

    @Test
    void bubbleSort_Null_Exception() {
        assertThrows(NullPointerException.class, () -> Sort.bubbleSort(null));
    }

    @Test
    void bubbleSort_EmptyArray_Exception() {
        EmptyArrayException e = assertThrows(EmptyArrayException.class,
                () -> Sort.bubbleSort(new int[0]));
        assertEquals("Cannot sort empty array", e.getMessage());
    }

    @Test
    void bubbleSort_SingleIndexArray_returnSameArray() {
        int[] single = new int[]{1};
        int[] single2 = new int[]{1};
        Sort.bubbleSort(single);
        assertArrayEquals(single2, single);
    }

    @Test
    void bubbleSort_UnSortedArray_MakeArraySortedFromLowToHigh() {
        Sort.bubbleSort(numbers);
        assertArrayEquals(numbers, sorted);
    }

    @Test
    void bubbleSort_SortedArray_ShouldStillBeSorted() {
        int[] sorted2 = new int[sorted.length];
        System.arraycopy(sorted, 0, sorted2, 0, sorted.length);
        Sort.bubbleSort(sorted2);
        assertArrayEquals(sorted, sorted2);
    }

    @Test
    void mergesort_shouldExist() {
        Sort.mergesort(numbers);
    }

    @Test
    void mergesort_Null_Exception() {
        assertThrows(NullPointerException.class, () -> Sort.mergesort(null));
    }

    @Test
    void mergesort_EmptyArray_Exception() {
        EmptyArrayException e = assertThrows(EmptyArrayException.class,
                () -> Sort.mergesort(new int[0]));
        assertEquals("Cannot sort empty array", e.getMessage());
    }
    @Test
    void mergesort_SingleIndexArray_returnSameArray() {
        int[] single = new int[]{1};
        int[] single2 = new int[]{1};
        Sort.mergesort(single);
        assertArrayEquals(single2, single);
    }

    @Test
    void mergesort_UnSortedArray_MakeArraySortedFromLowToHigh() {
        Sort.mergesort(numbers);
        assertArrayEquals(numbers, sorted);
    }

    @Test
    void mergesort_SortedArray_ShouldStillBeSorted() {
        int[] sorted2 = new int[sorted.length];
        System.arraycopy(sorted, 0, sorted2, 0, sorted.length);
        Sort.bubbleSort(sorted2);
        assertArrayEquals(sorted, sorted2);
    }
}
