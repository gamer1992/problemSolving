package com.guru.learning;

import java.util.regex.Pattern;

public class TesterPattern {

    static Pattern pt = Pattern.compile("aa");
    static Pattern pt2 = Pattern.compile("a");

    public static void main(String args[]) {
        String input = "caaab";
        if (pt.matcher("caaab").find()) {
            System.out.print("M1");
        }
        if (pt2.matcher("caaab").matches()) {
            System.out.print("M2");
        }

       System.out.println(countSuccessiveOnes(getBinaryCode(6)));
    }

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
        for (int i = input.length-1; i > 0; i--) {
            if (input[i]) {
                tempCount++;
            }else{
                maxCount=Math.max(tempCount,maxCount);
                tempCount=0;
            }
        }
        return Math.max(tempCount,maxCount);
    }


}
