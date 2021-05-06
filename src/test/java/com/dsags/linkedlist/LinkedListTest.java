package com.dsags.linkedlist;


import com.dsags.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    LinkedList list;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
    }

    @Test
    void newLinkedListShouldBeEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldBeAbleToAddNodeToEmptyListAsHead() {
        Node firstNode = new Node(1);
        list.add(firstNode);
        assertEquals(firstNode, list.getHead());
        assertFalse(list.isEmpty());
    }

    @Test
    void shouldAddToEndOfExistingList() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);
        assertEquals(thirdNode, list.getHead().getNext().getNext());
    }

    @Test
    void shouldAddToTheStartOfEmptyList() {
        Node firstNode = new Node(1);
        list.addFirst(firstNode);
        assertEquals(firstNode, list.getHead());
    }

    @Test
    void shouldAddToTheStartOfExistingList() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.addFirst(thirdNode);
        assertEquals(thirdNode, list.getHead());
        assertEquals(firstNode, list.getHead().getNext());
    }

    @Test
    void shouldGetLastWhenListIsEmpty() {
        assertNull(list.getLast());
    }

    @Test
    void shouldGetEndOfExistingList() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);
        assertEquals(thirdNode, list.getLast());
    }

    @Test
    void getNthItemInList() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        assertEquals(firstNode, list.get(1));
        assertEquals(secondNode, list.get(2));
        assertEquals(thirdNode, list.get(3));
    }

    @Test
    void getNthItemInListException() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(4);
        });

        assertEquals("Index is more than the number of elements.", exception.getMessage());
    }

    @Test
    void returnsIndexOfObjectIfExists() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        assertEquals(3, list.contains(thirdNode));

        Node notInList = new Node(7);

        assertEquals(-1, list.contains(notInList));
    }

    @Test
    void shouldDeleteHead() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        list.delete(firstNode);

        assertEquals(secondNode, list.getHead());
    }

    @Test
    void deleteObjectIfExists() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        list.delete(secondNode);

        assertEquals(firstNode.getNext(), thirdNode);
    }

    @Test
    void shouldDeleteLastNode() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        list.delete(thirdNode);

        assertEquals(secondNode, list.getLast());
        assertNull(secondNode.getNext());
    }


    @Test
    void deletesNthObjectFromListException() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.delete(4);
        });

        assertEquals("Index is more than the number of elements.", exception.getMessage());
    }

    @Test
    void deletesNthObjectFromList() throws IndexOutOfBoundsException {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        list.add(firstNode);
        list.add(secondNode);
        list.add(thirdNode);

        list.delete(2);
        assertEquals(firstNode.getNext(), thirdNode);
    }
}
