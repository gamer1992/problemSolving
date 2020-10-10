package com.guru.learning.queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueue <T>{

    private Queue<T> queue=new LinkedList<>();
    private Queue<T> queue2=new LinkedList<>();
    private int CURRENT_SIZE=0;

    public void push(T t){
        queue.add(t);
        CURRENT_SIZE++;
    }

    public void printF(){
      for(int i=0;i<CURRENT_SIZE;i++){
          System.out.print("Peek is :"+queue.peek());
          System.out.print("Removed is :" +queue.remove());
          System.out.println();
      }
    }

    // 1,2,3,4
    //  2,3,4
    //
    //

    public T poll(){
        T val =null;
        if(queue.isEmpty()&& queue2.isEmpty()){
            throw  new RuntimeException("Empty");
        }
        if(queue2.isEmpty()){
            while (queue.size()!=1) {
                queue2.add(queue.peek());
                queue.remove();
            }
        }
        val =queue.remove();

        Queue<T> temp=queue;
        queue=queue2;
        queue2=temp;

       return val;
    }
}
