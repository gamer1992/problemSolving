package com.guru.learning.strings;

import java.util.Arrays;
import java.util.List;

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
        List<String> inputs = Arrays.asList("Hacker", "Rank");

        for (String input : inputs) {
            process(input);
        }
    }
}
