package com.guru.learning;

public class BSTUtils {

    public static boolean isBST(Node<Integer> root){
        return isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    private  static boolean isBST(Node<Integer> root,int maximum, int minimum){
        if(root==null){
            return true;
        }
        if(root.data > maximum && root.data < minimum){
            return false;
        }
        return isBST(root.leftNode,root.data,minimum) && isBST(root.rightNode,minimum,root.data);
    }

    public static void revertTree(Node<Integer> root){
        Node<Integer> node=root;
        revert(root);
    }

    private static Node revert(Node<Integer> root) {
        if (root == null) {
            return root;
        }

        Node<Integer> rightNode = revert(root.leftNode);
        Node<Integer> leftNode = revert(root.rightNode);

        root.rightNode = rightNode;
        root.leftNode = leftNode;

        return root;

    }



}
