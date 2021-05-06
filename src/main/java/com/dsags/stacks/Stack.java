package com.dsags.stacks;

import com.dsags.Node;

public class Stack {

    private Node top = null;

    public boolean empty() {
        return top == null;
    }

    public void push(Object object) {
        Node newTop = new Node(object);
        newTop.setNext(top);
        top = newTop;
    }

    public Object peek() throws EmptyStackException {
        if(empty()) {
            throw new EmptyStackException("Cannot peek an empty stack");
        }
        return top.getValue();
    }

    public Object pop() throws EmptyStackException {
        if(empty()){
            throw new EmptyStackException("Cannot pop empty stack");
        }
        Node oldTop = top;
        top = oldTop.getNext();
        return oldTop.getValue();
    }

    public int search(Object object) {
        int position = 1;
        Node current = top;
        while(current != null) {
            if(current.getValue() == object) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }
}
