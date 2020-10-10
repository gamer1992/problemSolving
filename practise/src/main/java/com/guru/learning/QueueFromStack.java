package com.guru.learning;

import java.util.LinkedList;
import java.util.Stack;

public class QueueFromStack<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void enqueue(T t) {
        stack1.push(t);
    }

    public T topElement() {
        return stack2.peek();
    }

    public T dequeue() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new RuntimeException("Stack Over flow");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
