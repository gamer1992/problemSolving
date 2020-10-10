package com.guru.learning;

import java.util.Arrays;

public class TrainPlatform {

    public static void main(String args[]){

        double arrival[] ={900 ,940 ,950,1100,1500,1800};
        double departure[]={910,1200,1120,1130,1900,2000};

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int n=arrival.length;
        int i=1;
        int j=0;
        int result=1;
        int platform=1;

        while(i<n && j<n){
            if(arrival[i]>departure[j]){
                result--;
                j++;
            }else if(arrival[i]<=departure[j]){
                result++;
                i++;
            }

            System.out.println(result);
            if(result > platform){
                platform=result;
            }

        }

        System.out.println(platform);
    }
}
