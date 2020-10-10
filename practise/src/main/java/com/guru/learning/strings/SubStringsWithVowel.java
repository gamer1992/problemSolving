package com.guru.learning.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringsWithVowel {

    public static String findSubstring(String s, int k) {

        String input=s.substring(0, k);
        int initailCount=getCount(k, input);
        System.out.println(initailCount);
        int max=initailCount;

        for(int i=1;i<=s.length()-k;i++){
            System.out.println(s.substring(i,i+k));
            if(isVowel(s.substring(i-1, i))){
                initailCount--;
            }
            if(isVowel(s.substring(i+k-1, i+k))){
                initailCount++;
            }

            if(initailCount>max){
                input=s.substring(i, i+k);
            }else if(initailCount<=0){
                input="Not found!";
                initailCount=0;
            }else{
                initailCount=max;
            }
        }

        return input;
    }

    public static boolean isVowel(String s){
        String vowel="aeiou";
        return vowel.contains(s);
    }

    public static int getCount(int k, String input){
        int count=0;
        for(int i=0;i<k;i++){
            if(isVowel(input.substring(i, i+1))){
                count++;
            }
        }
        return count;
    }

    public static void main (String args[]){
        System.out.println(findSubstring("qwdftr",2));

    }

}
