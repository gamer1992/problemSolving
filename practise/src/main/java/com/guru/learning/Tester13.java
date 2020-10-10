package com.guru.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester13 {

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

    public static List<String> mostActive(List<String> customers) {
        Map<Integer,String> opCountToCust=new HashMap<>();
        Map<String,Integer> opCusToCount=new HashMap<>();
        for(String s: customers){
            if(opCusToCount.containsKey(s)){
                Integer count=opCusToCount.get(s);
                count++;
                opCusToCount.put(s, count);
            }else{
                opCusToCount.put(s, 1);
            }
        }

        int count=customers.size();
        List<String> output=new ArrayList<>();
        for(String key: opCusToCount.keySet()){
            Integer val=opCusToCount.get(key);
            double percenatge= (val*100)/count;
            if(percenatge >5.00){
                output.add(key);
            }
        }

        return output;
    }


}
