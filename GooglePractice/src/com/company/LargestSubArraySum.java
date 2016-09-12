package com.company;

import java.util.HashMap;

/**
 * Created by arun on 8/29/16.
 */
public class LargestSubArraySum {

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};

        int largestSum = LargestSumSubArray(array);
        System.out.println("Problem-1:   The sub array with largest sum is: "+ largestSum);

        int maxLengthSubArray = largestSubArrayWithZeroSum(array);
        System.out.println("Problem-2:  The maximum length of subArray whose sum is zero is: "+ maxLengthSubArray);

        System.out.println("Problem-3:");
        int sum = 3;
        printLargestSubArrayWithSum(array,sum);

    }

    /**
     * Problem:1
     * Find the contiguous subArray which has the largest sum
     * @param array
     * @return Max Sum
     */
    public static int LargestSumSubArray(int[] array){
        int maxSum = array[0];
        int currMax = array[0];

        for (int i=1;i<array.length;i++){
            currMax = Math.max(array[i],array[i]+currMax);
            maxSum = Math.max(maxSum,currMax);
        }
        return maxSum;
    }

    /**
     * Problem:2
     * Find largest subArray With sum Zero
     * @param array
     * @return Max length
     */
    public static int largestSubArrayWithZeroSum(int[] array){
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            sum = sum+array[i];
            if ((array[i] == 0)&&(maxLen==0)){
                maxLen = 1;
            }
            if (sum == 0){
                maxLen = i+1;
            }
            Integer prev = map.get(sum);
            if (prev!=null){
                maxLen = Math.max(maxLen,i-prev);
            }else {
                map.put(sum,i);
            }
        }
        return maxLen;
    }


    /**
     * Problem:3
     * Print subArray range with given sum.
     * @param array
     * @param sum
     */
    public static void printLargestSubArrayWithSum(int[] array, int sum){
        int subSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<array.length;i++){
            subSum = array[i]+subSum;
            if (subSum == sum){
                System.out.println("The given sum is in subArray 0 to "+i);
            }else {
                Integer prevSum = map.get(subSum-sum);
                if (prevSum!=null){
                    System.out.println("The given sum is in subArray "+(prevSum+1)+" to "+i);
                }else {
                    map.put(subSum,i);
                }
            }
        }
    }

}
