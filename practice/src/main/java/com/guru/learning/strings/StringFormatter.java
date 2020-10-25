package com.guru.learning.strings;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {
    public static void process(String s){
        StringBuilder bd = new StringBuilder(2*s.length());

        for(int i=0;i<s.length();i++){
            if(2*i>=s.length()){
                break;
            }
            bd.append(s.charAt(2*i));
        }

        bd.append("  ");
        for(int i=0;i<=s.length() ;i=(((i+1)*2)+1)){
            bd.append(s.charAt(i));
        }
        System.out.println(bd.toString());
    }
   /* 2
    Hacker
            Rank*/

    public static void main(String[] args) {

        int count=0;
        int k=0;
        int n=2;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j){
                    int k2=i&j;
                    if(k2> count && k2 < k){
                        count=k2;
                    }
                }
            }
        }
        System.out.println(count);

        List<String> inputs = Arrays.asList("Hacker", "Rank");
        TreeMap map=new TreeMap();
        //map.containsKey()
        for (String input : inputs) {
            process(input);
        }
    }
}
