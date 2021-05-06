package com.dsags.linkedlist;

import com.dsags.Node;

public class LinkedList {

    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
    }

    public Node getHead() {
        return head;
    }

    public void addFirst(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }

    public Node getLast() {
        Node currentNode = head;
        while (currentNode != null && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public Node get(int index) throws IndexOutOfBoundsException {
        Node currentNode = head;

        for (int j = 1; currentNode != null; j++) {
            if (j == index) return currentNode;
            currentNode = currentNode.getNext();
        }
        throw new IndexOutOfBoundsException("Index is more than the number of elements.");
    }

    public int contains(Node node) {
        Node currentNode = head;

        for (int index = 1; currentNode != null; index++) {
            if (currentNode == node) return index;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    public void delete(Node node) {
        if (head == node) {
            head = head.getNext();
            return;
        }
        Node currentNode = head;
        while (currentNode != null && currentNode.getNext() != null) {
            if (currentNode.getNext() == node) {
                currentNode.setNext(node.getNext());
                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Index is more than the number of elements.");
        }
        Node currentNode = head;

        for (int j = 1; currentNode.getNext() != null; j++) {
            if (j == index) {
                delete(currentNode);
                return;
            }
            currentNode = currentNode.getNext();
        }
        throw new IndexOutOfBoundsException("Index is more than the number of elements.");
    }
}
