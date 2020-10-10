package com.guru.learning;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tester {

    static long FindBigNum(long n) {
        List<Long> bd = new ArrayList<>();
        for (long i = 1; i < n + 1; i++) {
            bd.addAll(getBinaryValue(i));
        }
        System.out.print(bd);
        return convertToDecimal(bd);
    }

    static long convertToDecimal(List<Long> value) {
        long op = 0;
        for (int i = value.size() - 1; i >= 0; i--) {
            long digit = value.get(i);
            op += getPowerOfTwo(i) * digit;
        }
        return op;
    }

    static long getPowerOfTwo(long power) {
        long ouput = 1L;
        return calculatePowerOfTwo(power, ouput);
    }

    static long calculatePowerOfTwo(long power, long output) {
        if (power == 0) {
            return output;
        }
        return calculatePowerOfTwo(power - 1L, 2L * output);
    }


    static List<Long> getBinaryValue(long val) {
        List<Long> bd = new ArrayList<>();

        while (val > 0) {
         //   Math.pow()
            bd.add(val%2);
             val=val/2;
        }
        return bd;
    }

    public static void main(String args[]) {
     /*   QueueFromStack<Integer> queue=new QueueFromStack<>();
        int arr[] ={1,3,5,6,7,8};
        for (int i : arr){
            queue.enqueue(i);
        }
        for(int i=0;i<4;i++){
            System.out.print(queue.dequeue()+",");
        }
        queue.enqueue(9);
        System.out.print(queue.dequeue());
        System.out.print( queue.dequeue());
        System.out.print(queue.dequeue());*/
        /*StackFromQueue<Integer> stackFromQueue=new StackFromQueue<>();
        int arr[] ={1,3,5,6,7,8};
        for(int i : arr){
            stackFromQueue.push(i);
        }
        for(int i=0;i <arr.length;i++){
            System.out.print(stackFromQueue.poll());
        }*/









/*
        long val = FindBigNum(3);
        long val2 = val;

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int array[] = {50, 30, 20, 40, 70, 60,80};
        for (int x : array) {
            bst.addNode(x);
        }
        System.out.println("------------------------");
        bst.printPreInOrder();
        boolean val=bst.delete(30);
        System.out.println(val);
        System.out.println("------------------------");
        bst.printPreInOrder();
        Node<Integer> head =bst.getHeadNode();
        System.out.println(BSTUtils.isBST(head));
        bst.printPostOrder();
        BSTUtils.revertTree(bst.getHeadNode());
        System.out.println("------------------------");
        bst.printPreInOrder();
*/



/*                50
            40         70
        20          60      80*/
/*      50
    70      40
 80  60         20 */
//60,70,80,50,20,40
/*        1      0     1         0    1    0     0    1
          128   64    32       16    8   4     2    1

        */


        // bst.printPostOrder();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int array[] = {50, 30, 20};
        for (int x : array) {
            bst.addNode(x);
        }

        int count=findLeafNodes(bst.getHeadNode(),0);
        System.out.println(count);
        System.out.print(findDepth(bst.getHeadNode()));
    }

    static  int findLeafNodes(Node<Integer> node,int count){

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
