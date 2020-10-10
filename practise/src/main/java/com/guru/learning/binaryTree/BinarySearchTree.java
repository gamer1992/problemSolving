package com.guru.learning.binaryTree;

public class BinarySearchTree<T> {

    private Node<T> root;

   public <T> void addNode(T t) {

        root = addNode(root, t);
    }

    private int compareTo(String key, String key2) {
        return key.compareTo(key2);
    }

    public <T> Node addNode(Node root, T t) {
        if (root == null) {
            return new Node<T>(t);
        }
        int result = compareTo(root.data.toString(), t.toString());

        if (result < 0) {
            root.rightNode = addNode(root.rightNode, t);
        } else {
            root.leftNode = addNode(root.leftNode, t);
        }

        return root;
    }

    public void printPreInOrder() {
        printPreInOrderHelper(root);
        System.out.println();
    }

    public void printPostOrder() {
        printPostOrderHelper(root);
    }

    private void printPreInOrderHelper(Node<T> root) {
        if (root == null) {
            return;
        }
        printPreInOrderHelper(root.leftNode);
        System.out.print(",");
        System.out.print(root.data);
        printPreInOrderHelper(root.rightNode);
    }

    private void  printPostOrderHelper(Node<T> root){
        if(root==null){
            return ;
        }
        printPostOrderHelper(root.leftNode);
        printPostOrderHelper(root.rightNode);
        System.out.print(root.data);
        System.out.print(",");
    }

    private void printPreOrderHelper(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        System.out.println();
        printPreInOrderHelper(root.leftNode);
        printPreInOrderHelper(root.rightNode);
    }

    public boolean delete(T data) {
        return deleteNode(root, data) != null;
    }

    private Node deleteNode(Node<T> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.data.equals(key)) {
            return removeNode(root);
        }
        int result = compareTo(root.data.toString(), key.toString());

        if (result > 0) {
            root.leftNode = deleteNode(root.leftNode, key);
        } else {
            root.rightNode = deleteNode(root.rightNode, key);
        }

        return root;

    }

    private Node removeNode(Node<T> root) {
        if (root == null) {
            return null;
        }
        if (root.leftNode == null && root.rightNode == null) {
            return null;
        }
        if (root.leftNode == null) {
            return root.rightNode;
        }
        if (root.rightNode == null) {
            return root.leftNode;
        }
        T data= findInOrderAncestor(root.rightNode);
        deleteNode(root,data);
        root.data=data;
        return root;
    }

    private T findInOrderAncestor(Node<T> right) {
        if (right != null) {
            if (right.leftNode != null) {
                return findInOrderAncestor(right.leftNode);
            }
            return right.data;
        }
        return  null;
    }

    private Node<T> invert(Node<T> root){
        if(root==null){
            return root;
        }
        Node<T> left=invert(root.leftNode);
        Node<T> right=invert(root.rightNode);

        root.rightNode=left;
        root.leftNode=right;

        return root;
    }

    public Node<T> getHeadNode(){
        return root;
    }

}
