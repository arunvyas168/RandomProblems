package com.company;

/**
 * Created by arun on 8/29/16.
 */
public class EggBreaking {
    public static void main(String[] args) {
        int numEggs = 2;
        int numFloors = 6;
        int minThrows = findMinThrows(numFloors, numEggs);
        System.out.println(minThrows);
    }

    public static int findMinThrows(int numFLoors, int numEggs){
        int dp[][] = new int[numEggs+1][numFLoors+1];
        for (int i=0;i<=numFLoors;i++){
            dp[1][i] = i;
        }
        int c  = 0;
        for (int egg=2;egg<=numEggs;egg++){
            for (int floor=1;floor<=numFLoors;floor++){
                if (egg>floor){
                    dp[egg][floor] = dp[egg-1][floor];
                }else{
                    dp[egg][floor] = Integer.MAX_VALUE;
                    for (int k=1;k<floor;k++){
                        c = 1+ Math.max(dp[egg-1][k-1],dp[egg][floor-k]);
                        if (dp[egg][floor]>c){
                            dp[egg][floor] = c;
                        }
                    }
                }
            }
        }

        return dp[numEggs][numFLoors];
    }
}

/**
 *  Formula:
 *
 *  if(egg>floor){
 *      dp[egg][floor] = dp[egg-1][floor-1];
 *  }else{
 *      dp[egg][floor] = Min( 1+ MAX(dp[egg-1][k-1], dp[egg][floor-k]))
 *  }
 *  where k is between 1.....floor;
 *
 *
 *  for (int i=0;i<=numFLoors;i++){
 *      dp[1][i] = i;
 *  }
 *
 *  dp[egg][floor] = integer.max_value
 *
 *  for(int k =1;k<floor;k++){
 *      c = 1+ Math.max(dp[egg-1][k-1],dp[egg][floor-k]
 *      if(dp[egg][floor]>c){
 *          dp[egg][flor] = c;
 *      }
 *  }
 *
 *
 *
 * **/










