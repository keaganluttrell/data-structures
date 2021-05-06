package com.dsags.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    Queue freshQueue;

    @BeforeEach
    void setUp() {
        freshQueue = new Queue();
    }

    @Test
    void newQueueShouldBeEmpty() {
        assertTrue(freshQueue.empty());
    }

    @Test
    void shouldBeAbleToAddToQueueAndQueueNotEmpty() {
        freshQueue.add(9);

        assertEquals(9, freshQueue.peek());
        assertFalse(freshQueue.empty());
    }

    @Test
    void shouldBeAbleToAddAndRemoveObjectsFromQueue() {
        freshQueue.add(1);
        freshQueue.add(2);
        freshQueue.add(3);

        assertEquals(1, freshQueue.peek());
        assertEquals(1, freshQueue.remove());
        assertEquals(2, freshQueue.peek());
        assertEquals(2, freshQueue.remove());
        assertEquals(3, freshQueue.peek());
        assertEquals(3, freshQueue.remove());
        assertNull(freshQueue.peek());
    }

    @Test
    void removeShouldThrowExceptionIfListIsEmpty() {
        freshQueue.add(1);
        assertEquals(1, freshQueue.remove());

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            freshQueue.remove();
        });
        assertEquals("Cannot remove null value", exception.getMessage());
    }

    @Test
    void pollShouldReturnNullIfQueueIsEmpty() {
        freshQueue.add(1);

        assertEquals(1, freshQueue.remove());
        assertNull(freshQueue.poll());
    }

    @Test
    void pollShouldReturnValueIfQueueIsNotEmpty() {
        freshQueue.add(1);
        freshQueue.add(2);

        assertEquals(1, freshQueue.poll());
        assertEquals(2, freshQueue.peek());
    }

    @Test
    void elementMethodShouldThrowExceptionForEmptyQueue() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            freshQueue.element();
        });
        assertEquals("Cannot remove null value", exception.getMessage());
    }

    @Test
    void elementMethodShouldReturnValueIfQueueIsNotEmpty() {
        freshQueue.add(9);
        assertEquals(9, freshQueue.element());
    }
}
