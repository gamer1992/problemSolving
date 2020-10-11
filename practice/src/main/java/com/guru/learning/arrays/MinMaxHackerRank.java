package com.guru.learning.arrays;

import com.guru.learning.Tuple;

import java.util.Arrays;
/*
Given five positive integers, find the minimum and maximum values that can be calculated
        by summing exactly four of the five integers. Then print the respective minimum
        and maximum values as a single line of two space-separated long integers.

*/
public class MinMaxHackerRank {

   static Tuple findMinMax(int[] inputs){
        Arrays.sort(inputs);
        long sum=0;
        long minimum=Integer.MAX_VALUE;
        long maximum=Integer.MIN_VALUE;

       for (int input : inputs) {
           sum = sum + input;
       }

        minimum=sum-inputs[4];
        maximum=sum-inputs[0];

       return new Tuple<>(minimum, maximum);
    }

    public static void main (String[] args){
        int[] inputs = {942381765, 627450398, 954173620, 583762094, 236817490};
        System.out.print(findMinMax(inputs).toString());
    }
//2390411747 3107767877
}
