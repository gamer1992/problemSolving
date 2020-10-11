package com.guru.learning.binaryTree;

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

    static  int findLeafNodes(Node<Integer> node, int count){

        if(node==null){
            return 0;
        }

        int leftCount=findLeafNodes(node.rightNode,count);
        int rightCount=findLeafNodes(node.leftNode,count);

        if(node.rightNode==null && node.leftNode==null){
            count++;
        }

        return count+leftCount+rightCount;

    }


    static int findDepth(Node<Integer> node){
        if(node==null){
            return  0;
        }

        int lf=findDepth(node.rightNode);
        int rf=findDepth(node.leftNode);

        return 1+ Math.max(lf,rf);
    }



}
