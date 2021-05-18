package com.dsags.sorts;

public class Sort {

    private static String emptyArrayMsg = "Cannot sort empty array";

    public static void quicksort(int[] array) {
        if (array.length == 0) throw new EmptyArrayException(emptyArrayMsg);
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int start, int end) {
        if (start >= end) return;
        int left = start + 1;
        int right = end;
        while (right >= left) {
            if (array[left] > array[start] && array[right] < array[start]) {
                swap(array, left, right);
            }
            if (array[left] <= array[start]) left++;
            if (array[right] >= array[start]) right--;
        }
        swap(array, start, right);
        boolean LeftSubArrayIsSmaller = right - 1 - start < end - (right + 1);
        if (LeftSubArrayIsSmaller) {
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

    public static void bubbleSort(int[] array) {
        if (array.length == 0) throw new EmptyArrayException(emptyArrayMsg);

        boolean swapped = true;
        int bubbles = 1;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - bubbles; i++) {
                if (i == array.length - bubbles) break;
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            bubbles++;
        }
    }

    public static void mergesort(int[] array) {
        if(array.length == 0) throw new EmptyArrayException(emptyArrayMsg);
        sort(array, new int[array.length], 0, array.length - 1);
    }

    private static void sort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;
        int mid = (leftStart + rightEnd) / 2;
        sort(array, temp, leftStart, mid);
        sort(array, temp, mid + 1, rightEnd);
        merge(array, temp, leftStart, rightEnd);
    }

    private static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

}
