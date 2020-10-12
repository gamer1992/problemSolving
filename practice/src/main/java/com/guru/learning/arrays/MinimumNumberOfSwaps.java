package com.guru.learning.arrays;

import org.junit.Assert;

public class MinimumNumberOfSwaps {
    /*
       int [] consecutiveIntegers={ 1,3,2,5,4 }

       Two approaches : One is by Using Selection Sort Other one is by Finding a cycle

       Find a Cycle :

       Keep a Boolean Array : boolean [] visited = {false , false , false , false , false}

       Iterate through the Array and DO following things :

       If the number is at the correct positions , then just mark them visited

       if  i+1 =consecutiveIntegers[i]  then mark visited[true] and do not increment the Count

       If not then mark them visted and navigate to the value which is present in the Index , do this until there is a visited Node.

       else
       consecutiveIntegers[i] =currentValue

       else  navigate to consecutiveIntegers[ currentValue] and mark visited[currentValue]
       an Increment the Swaps

       ie , at index 2 , current Value is 3 , so move to consecutiveIntegers[3]  .

       the  value at consecutiveIntegers[3] is 2 , Increment the count and now move to the consecutiveIntegers[2]

       when we navigate to consecutiveIntegers[2], its already visited. Break the loop .

     */

    private static int minimumNumberSwaps(int[] inputs) {

        boolean[] visited = new boolean[inputs.length];
        int minimumSwaps = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (inputs[i] != i + 1) {
                    int currentValue = inputs[i]-1;
                    while (!visited[currentValue]) {
                        visited[currentValue] = true;
                        currentValue = Math.min(inputs.length-1,inputs[currentValue]);
                        ++minimumSwaps;
                    }
                }
            }
        }

        return minimumSwaps;
    }

    public static void main(String[] args) {
        int[] consecutiveIntegers = {4, 3, 1, 2};
        Assert.assertEquals(3, minimumNumberSwaps(consecutiveIntegers));
        int[] testCase2 = {1, 3, 5, 2, 4, 6, 7};
        Assert.assertEquals(3,minimumNumberSwaps(testCase2));
        int [] consecutiveIntegers_testCase3={ 1,3,2,5,4 };
        Assert.assertEquals(2,minimumNumberSwaps(consecutiveIntegers_testCase3));

    }
}
