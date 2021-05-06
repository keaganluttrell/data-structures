package com.dsags.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack freshStack;

    Stack initLoadedStack() {
        Stack loadedStack = new Stack();
        loadedStack.push(1);
        loadedStack.push(2);
        loadedStack.push(4);
        loadedStack.push(5);
        return loadedStack;
    }

    @BeforeEach
    void setUp() {
        freshStack = new Stack();
    }

    @Test
    void stackShouldStartEmpty() {
        assertTrue(freshStack.empty());
    }

    @Test
    void peekShouldThrowEmptyStackExceptionForEmptyStack() {
        freshStack = new Stack();
        EmptyStackException exception = assertThrows(
                EmptyStackException.class, () -> freshStack.peek()
        );
        assertEquals("Cannot peek an empty stack", exception.getMessage());
    }

    @Test
    void shouldPushNewValueToTopOfEmptyStack() throws EmptyStackException {
        freshStack.push(9);
        assertEquals(9, freshStack.peek());
        assertFalse(freshStack.empty());
    }

    @Test
    void shouldPushNewValueToTopOfStack() throws EmptyStackException {
        freshStack.push(9);
        freshStack.push(10);
        assertEquals(10, freshStack.peek());
    }

    @Test
    void popShouldThrowExceptionForEmptyStack() {
        EmptyStackException exception = assertThrows(
                EmptyStackException.class, () -> freshStack.pop()
        );
        assertEquals("Cannot pop empty stack", exception.getMessage());
    }

    @Test
    void shouldPopValueOffTopOfStackAndReturnValue() throws EmptyStackException {
        freshStack.push(9);
        freshStack.push(10);
        assertEquals(10, freshStack.pop());
        assertEquals(9, freshStack.peek());
    }

    @Test
    void searchShouldReturnNegativeOneIfStackIsEmpty() {
        assertEquals(-1, freshStack.search(8));
    }

    @Test
    void searchShouldReturnOneBasedIndexIfFound() {
        Stack loadedStack = initLoadedStack();
        assertEquals(4, loadedStack.search(1));
        assertEquals(2, loadedStack.search(4));
    }

    @Test
    void searchShouldReturnNegativeOneForMissingObject() {
        Stack loadedStack = initLoadedStack();
        assertEquals(-1, loadedStack.search(3));
    }

}
