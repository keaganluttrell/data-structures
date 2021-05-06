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
        int j = 1;

        Node currentNode = head;
        while (currentNode.getNext() != null && j != index) {
            currentNode = currentNode.getNext();
            j++;
        }

        if (j != index) {
            throw new IndexOutOfBoundsException("Index is more than the number of elements.");
        }

        return currentNode;
    }

    public int contains(Node node) {
        int j = 1;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode == node) {
                return j;
            }

            currentNode = currentNode.getNext();
            j++;
        }

        return -1;
    }

    public void delete(Node node) {

        if (head == node) {
            head = head.getNext();
            return;
        }

        Node currentNode = head;

        while (currentNode.getNext() != node && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext() == node) {
            currentNode.setNext(node.getNext());
        }
    }

    public void delete(int index) throws IndexOutOfBoundsException{
        int j = 1;

        Node currentNode = head;

        while(j != index && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            j++;
        }
        if(j != index) {
            throw new IndexOutOfBoundsException("Index is more than the number of elements.");
        } else if (j == index) {
            delete(currentNode);
        }

    }
}
