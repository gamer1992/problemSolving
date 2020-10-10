package com.guru.learning.arrays;

import java.util.Scanner;

public class HourGlass {

    public static int maxHourGlass(int[][] a) {
        int hourGlass = Integer.MIN_VALUE;

        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 0; j < a[i].length - 2; j++) {
                int temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1] + a[i + 2][j]
                        + a[i + 2][j + 1] + a[i + 2][j + 2];
                hourGlass = Math.max(hourGlass, temp);
            }
        }
        return hourGlass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        System.out.println(maxHourGlass(arr));
        scanner.close();



    }



}


