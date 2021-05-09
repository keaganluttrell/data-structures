package com.dsags.heaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MinHeapTest {
    MinHeap minHeap;

    @BeforeEach
    void setUp() {
        minHeap = new MinHeap();
    }

    @Test
    void minHeapShouldStartEmpty() {
        MinHeap minHeap = new MinHeap();
        assertTrue(minHeap.empty());
    }

    @Test
    void canAddSingleObjectToMinHeap() {
        minHeap.add(0);
        assertEquals(1, minHeap.size());
        assertFalse(minHeap.empty());
    }

    @Test
    void canAddTwoObjectsToMinHeap() {
        minHeap.add(9);
        minHeap.add(5);
        assertEquals(2, minHeap.size());
    }

    @Test
    void shouldBeDynamicWhenSizeIsGreaterThanCapacity() {
        for (int i = 0; i < 11; i++) {
            minHeap.add(i);
        }
        assertEquals(11, minHeap.size());
    }

    @Test
    void shouldBeDynamicWhenSizeIsAQuarterOfCapacity() {
        for (int i = 0; i < 40; i++) {
            minHeap.add(i);
        }
        for (int i = 31; i > 0; i-- ) {
            minHeap.poll();
        }
        assertEquals(9, minHeap.size());
        assertEquals(20, minHeap.getCapacity());
    }

    @Test
    void shouldRemoveTopOfHeap() {
        minHeap.add(9);
        assertEquals(9, minHeap.poll());
        assertTrue(minHeap.empty());
    }

    @Test
    void shouldAddAndRemoveItemsWhileMinNumIsAtTop() {
        for(int i = 100; i > 0; i--) {
            minHeap.add(i);
            assertEquals(i, minHeap.peek());
        }
        for(int i = 1; !minHeap.empty(); i++) {
            assertEquals(i, minHeap.poll());
        }
    }

}
