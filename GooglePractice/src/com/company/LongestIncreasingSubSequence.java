package com.company;

import java.util.Arrays;

/**
 * Created by arun on 8/30/16.
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] array = {15, 27, 14, 38, 26, 55, 46, 65, 85};
        int longestIncSubSeq = findLongestIncSubSeq(array);
        System.out.println("The length of longest Increasing subSequence is: "+longestIncSubSeq);
    }

    public static int findLongestIncSubSeq(int[] array){
        int[] dp = new int[array.length];
        Arrays.fill(dp,1);

        int[] actualSolution = new int[array.length];
        for(int i=0; i < actualSolution.length; i++){
            actualSolution[i] = i;
        }

        int maxIndex = 0;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<i;j++){
                if(array[j]<array[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    actualSolution[i] = j;
                    if (dp[i]>maxIndex){
                        maxIndex = i;
                    }
                }
            }
        }

        /*
         * Print the actual seq
         */

        int index;
        int newIndex = maxIndex;
        do{
            index = newIndex;
            System.out.print(array[index] + " ");
            newIndex = actualSolution[index];
        }while(index != newIndex);
        System.out.println();


        return dp[maxIndex];
    }


}
