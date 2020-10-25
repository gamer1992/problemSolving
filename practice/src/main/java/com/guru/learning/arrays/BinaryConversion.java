package com.guru.learning.arrays;

public class BinaryConversion {

    private static boolean[] getBinaryCode(int n) {
        boolean[] decimal = new boolean[40];
        int index = 0;
        while (n > 0) {
            int temp = n % 2;
            decimal[index++] = temp == 1;
            n = n / 2;
        }
        return decimal;
    }

    public static int countSuccessiveOnes(boolean[] input) {
        int maxCount=0, tempCount = 0;
        for (int i = input.length-1; i >= 0; i--) {
            if (input[i]) {
                tempCount++;
            }else{
                maxCount=Math.max(tempCount,maxCount);
                tempCount=0;
            }
            maxCount=Math.max(tempCount,maxCount);
        }

        return maxCount;
    }

    public static void main (String args[]){
        boolean[] op= getBinaryCode(65535);
        System.out.print(countSuccessiveOnes(op));
    }

}
