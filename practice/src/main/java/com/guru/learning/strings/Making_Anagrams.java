package com.guru.learning.strings;

import org.junit.Assert;
import org.junit.Test;

public class Making_Anagrams {

    static int makeAnagram(String a, String b) {
        int [] charArray_a=new int [1024];
        int [] charArray_b=new int [1024];

        updateCount(charArray_a ,a);
        updateCount(charArray_b ,b);

       return calculateRemovals(charArray_a,charArray_b);
    }

    static void updateCount(int [] charArray,String input){
        for( char c : input.toCharArray()){
            charArray[(int)c]++;
        }
    }

    static  int calculateRemovals(int[] charArray1, int [] charArray2){
        int count=0;
       for(int i=0;i<charArray1.length;i++){
           if(charArray1[i]!=charArray2[i]){
               count+=Math.abs(charArray1[i]-charArray2[i]);
           }
       }
       return  count;
    }

    @Test
    public  void testMakeAnagram(){
        Assert.assertEquals(4,
        makeAnagram("cde","abc"));
    }

    @Test
    public void testMakeAnagrams2(){
        Assert.assertEquals(30,
                makeAnagram(
        "fcrxzwscanmligyxyvym",
                "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }

}
