package com.company;

/**
 * Created by arun on 9/6/16.
 */
public class MaxSumSubseqNonAdjacent {
    public static void main(String[] args) {
        int[] array= {4,1,1,4,2,1};
        int maxSum = findMaxSumNonAdj(array);
        System.out.println(maxSum);
    }

    public static int findMaxSumNonAdj(int[] array){
        if (array.length == 0){
            return 0;
        }
        int inclusive = array[0];
        int exclusive = 0;

        for(int i=1;i<array.length;i++){
            int newInclusive = Math.max (inclusive,exclusive+array[i]);
            exclusive = inclusive;
            inclusive = newInclusive;
        }

        return Math.max(inclusive,exclusive);

    }

}
