package com.guru.learning.leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int op [] =new int [nums.length];
        Arrays.fill(op,Integer.MIN_VALUE);
        int result=op[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=0 && op [i-1]<0){
                op[i]=nums[i];
            }else if (nums[i] < 0  && op [i-1]<0){
                op[i]=Math.max(op[i-1],nums[i]);
            }else {
                op[i]=op[i-1]+nums[i];
            }
            result=Math.max(result,op[i]);
        }
        return result;
    }

    @Test
    public void test_maxSubArray(){
        int sum [] ={-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(6,maxSubArray(sum));
        int sum2 [] ={1};
        Assert.assertEquals(1,maxSubArray(sum2));
        int sum3 [] ={-1,0};
        Assert.assertEquals(0,maxSubArray(sum3));
    }

}
