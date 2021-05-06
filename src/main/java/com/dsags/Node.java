package com.dsags;

public class Node {
    private final Object value;
    private Node next = null;

    public Node(Object object) {
        this.value = object;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
