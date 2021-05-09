package com.dsags.heaps;

import java.util.Arrays;

public class MinHeap {

    public int getCapacity() {
        return capacity;
    }

    private int capacity = 10;
    private int length = 0;

    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < length;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < length;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void ensureExtraCapacity() {
        if (length == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void decreaseCapacity() {
        if (capacity > 10 && length < capacity * .25) {
            items = Arrays.copyOf(items, capacity / 2);
            capacity /= 2;
        }
    }

    public boolean empty() {
        return length == 0;
    }

    public void add(int value) {
        ensureExtraCapacity();
        items[length++] = value;
        heapifyUp();
    }

    public int size() {
        return length;
    }

    public Object peek() {
        if (empty()) throw new IllegalStateException();
        return items[0];
    }

    public Object poll() {
        if (empty()) throw new IllegalStateException();
        Object object = items[0];
        items[0] = items[--length];
        heapifyDown();
        decreaseCapacity();
        return object;
    }

    private void heapifyUp() {
        int index = length - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) break;

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }
}
