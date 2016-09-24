package com.company;

import java.util.Arrays;

/**
 * Created by arun on 8/30/16.
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] array = {15, 27, 14, 38, 26, 55, 46, 65, 85};
        int longestIncSubSeqNLogN = findLongestIncSubSeqNlogN(array);
        System.out.println("The longest Increasing subSequence in NLogN: "+longestIncSubSeqNLogN);

        //O(n^2) method
        int longestIncSubSeq = findLongestIncSubSeq(array);
        System.out.println("The length of longest Increasing subSequence is: "+longestIncSubSeq);
    }


    public static int binarySearch(int[] dp, int low, int high, int key){
        while(high-low>1){
            int mid  = low + (high-low)/2;
            if(dp[mid]>= key){
                high = mid;
            }else{
                low = mid;
            }
        }
        return high;
    }

    /**
     *Our strategy determined by the following conditions,

     1. If A[i] is smallest among all end
     candidates of active lists, we will start
     new active list of length 1.

     2. If A[i] is largest among all end candidates of
     active lists, we will clone the largest active
     list, and extend it by A[i].


     3. If A[i] is in between, we will find a list with
     largest end element that is smaller than A[i].
     Clone and extend this list by A[i]. We will discard all
     other lists of same length as that of this modified list.
     */

    static int findLongestIncSubSeqNlogN(int[] array)
    {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int len = 1;
        for(int i=1;i<array.length;i++){
            //case-1;
            if(array[i]<dp[0]){
                dp[0] = array[i];
            }
            // case-2:
            else if(array[i]>dp[len-1]){
                dp[len++] = array[i];
            }
            //case-3:
            else{
                int index = binarySearch(dp,-1,len-1,array[i]);
                dp[index] = array[i];
            }
        }

        return  len;
    }
























    /**
     * O(n^2) method
     * @param array
     * @return
     */
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
/**
 *Our strategy determined by the following conditions,

 1. If A[i] is smallest among all end
 candidates of active lists, we will start
 new active list of length 1.

 2. If A[i] is largest among all end candidates of
 active lists, we will clone the largest active
 list, and extend it by A[i].


 3. If A[i] is in between, we will find a list with
 largest end element that is smaller than A[i].
 Clone and extend this list by A[i]. We will discard all
 other lists of same length as that of this modified list.
 */