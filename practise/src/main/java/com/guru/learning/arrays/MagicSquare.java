package com.guru.learning.arrays;

public class MagicSquare {
    static int formingMagicSquare(int[][] s) {
        int leftDiagonalSum = s[0][0] + s[1][1] + s[2][2];
        int rightDiagonalSum = s[0][2] + s[1][1] + s[2][0];
        int middleDiagonalSum = s[1][0] + s[1][1] + s[1][2];
        int crossSumMiddle = s[0][1] + s[1][1] + s[2][1];

        int maximumValue = 15;
        return findAdjustments(leftDiagonalSum, maximumValue, s[1][1], s[2][2], s[0][0])
                + findAdjustments(rightDiagonalSum, maximumValue, s[1][1], s[2][0], s[0][2])
                + findAdjustments(middleDiagonalSum, maximumValue, s[1][1], s[1][0], s[1][2])
                + findAdjustments(crossSumMiddle, maximumValue, s[1][1], s[2][1], s[0][1]);
    }

    private static int findAdjustments(int leftDiagonalSum, int maximumValue,
                                       int middle, int bottom, int start
    ) {
        if (leftDiagonalSum == maximumValue) {
            return 0;
        }
        int remainder = maximumValue - middle;
        int rpoint = remainder - bottom;
        int leftPointer = remainder - start;
System.out.println(Math.max(Math.abs(rpoint - start), Math.abs(leftPointer - bottom)));
        return Math.max(Math.abs(rpoint - start), Math.abs(leftPointer - bottom));

    }

    public static void main(String args[]) {
        /*int[][] inputs = {{4, 8, 2}, {4, 5, 7}, {6, 1, 6}};
        System.out.println(formingMagicSquare(inputs));
        int[][] inputs2 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}};
        System.out.println(formingMagicSquare(inputs2));*/
        int[][] inputs23 = {{2, 9, 8}, {4, 2, 7}, {5, 6, 7}};
        System.out.println(formingMagicSquare(inputs23));
    /*    4 8 2
          4 5 7
          6 1 4


          4 9 2
          3 5 7
          8 1 5

          2 9 8
4 2 7
5 6 7
     */


    }
}
