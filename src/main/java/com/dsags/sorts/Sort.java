package com.dsags.sorts;

public class Sort {

    public static void quicksort(int[] array) {
        if(array.length == 0) throw new EmptyArrayException("Cannot sort empty array");
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int start, int end) {
        if(start >= end) return;
        int left = start + 1;
        int right = end;
        while(right >= left) {
            if(array[left] > array[start] && array[right] < array[start]) {
                swap(array, left, right);
            }
            if(array[left] <= array[start]) left++;
            if(array[right] >= array[start]) right--;
        }
        swap(array, start, right);
        boolean LeftSubArrayIsSmaller = right - 1 - start < end - (right + 1);
        if(LeftSubArrayIsSmaller) {
            quicksort(array, start, right - 1);
            quicksort(array, right + 1, end);
        } else {
            quicksort(array, right + 1, end);
            quicksort(array, start, right - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
