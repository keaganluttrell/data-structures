package com.dsags;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeTest {
    @Test
    void nodeShouldHaveAnObjectPropertyAndNextProperty() {
        Integer i = 9;
        Node node = new Node(i);
        assertEquals(i, node.getValue());
        assertNull(node.getNext());
    }

    @Test
    void nodeShouldBeAbleToSetANextProperty() {
        Node node = new Node(9);
        Node nextNode = new Node(10);
        node.setNext(nextNode);
        assertEquals(10, node.getNext().getValue());
    }
}
