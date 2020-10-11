package com.guru.learning.arrays;

import java.util.Arrays;

public class TrainPlatform {

    public int getMinimumPlatForms(
            double[] arrival,
            double[] departure
    ) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int n = arrival.length;
        int i = 1;
        int j = 0;
        int result = 1;
        int platform = 1;

        while (i < n && j < n) {
            if (arrival[i] > departure[j]) {
                result--;
                j++;
            } else if (arrival[i] <= departure[j]) {
                result++;
                i++;
            }

            System.out.println(result);
            if (result > platform) {
                platform = result;
            }

        }
        return result;
    }


}
