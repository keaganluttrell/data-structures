package com.dsags.queues;

import com.dsags.Node;

import java.util.NoSuchElementException;

public class Queue {

    private Node head = null;
    private Node tail = null;

    public boolean empty() {
        return head == null;
    }

    public void add(Object object) {
        Node newNode = new Node(object);

        if (head == null) head = newNode;
        else tail.setNext(newNode);

        tail = newNode;
    }

    public Object peek() {
        if (head == null) return null;
        return head.getValue();
    }

    public Object remove() throws NoSuchElementException {
        if (empty()) {
            throw new NoSuchElementException("Cannot remove null value");
        }
        if (head == tail) {
            tail = null;
        }
        Object value = head.getValue();
        head = head.getNext();
        return value;
    }

    public Object poll() {
        if (head == null) return null;
        return remove();
    }

    public Object element() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove null value");
        }
        return peek();
    }
}
