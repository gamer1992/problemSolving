package com.guru.learning.arrays;


import java.util.ArrayList;
import java.util.List;

public class BigNumberBinaryConversion {

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

}
