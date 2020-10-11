package com.guru.learning.binaryTree;

public  class Node<T> {

    public Node<T> rightNode;

    public Node<T> leftNode;

    public T data;

    public Node(T t){
        this.data=t;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
