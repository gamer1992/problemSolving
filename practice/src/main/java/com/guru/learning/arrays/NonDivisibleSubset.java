package com.guru.learning.arrays;

import java.util.*;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int modular[] =new int[k];
        for(int i=0;i<s.size();i++){
            modular[s.get(i)%k]++;
        }
        int numberOfZeros=Math.min(modular[0],1);
        int middleNumber=0;
        //{1,4,2,7}
        //{0,3,1)
        if(k%2==0) {
            middleNumber = Math.min(modular[k / 2], 1);
        }
        int maximumCombinations=0;
        for(int i=1;i<=k/2;i++){
            maximumCombinations+=Math.max(modular[k-i],modular[i]);
        }
       return maximumCombinations+numberOfZeros+middleNumber;
    }


    public static void main(String args[]) {
        //int [] inputs={1,4,2,7};
        List<Integer> inputs = Arrays.asList(1, 4, 2, 7);
        System.out.println(nonDivisibleSubset(3, inputs));
      //  2,7,12,17,22
        inputs=Arrays.asList(278,576,496,727,410,124,338,149,209,702,282,718,771,575,436);
        System.out.println(nonDivisibleSubset(7, inputs));
       inputs=Arrays.asList(2,7,12,17,22);
        System.out.println(nonDivisibleSubset(3, inputs));
    }


}
