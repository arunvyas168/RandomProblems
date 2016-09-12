package com.company;


/**
 * Created by arun on 9/2/16.
 */
public class MaxSumIncrSubsequence {
    public static void main(String[] args) {
        int[] array = {1, 101, 2, 3, 100, 4, 5};
        int maxSumIncSubSeq = findMaxSumIncSubSeq(array);
        System.out.println("Sum of maximum sum increasing subsequence is: "+maxSumIncSubSeq);
    }

    public static int findMaxSumIncSubSeq(int[] array){
        int[] sumArray = new int[array.length];
        int[] backTrack = new int[array.length];

        //initialize the sumArray with values as if Max sum is atleast itself
        for(int i=0;i<array.length;i++){
            sumArray[i] = array[i];
        }
        backTrack[0] = 0;
        int max = 0;
        int maxIndex = -1;

        for (int i=1;i<array.length;i++){
            for (int j=0;j<i;j++){
                if (array[j]<array[i]){
                    if (sumArray[j]+array[i]>sumArray[i]){
                        sumArray[i] = sumArray[j]+array[i];
                        backTrack[i] = j;
                        if (max<sumArray[i]){
                            max = sumArray[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        //Print actual sub seq:
        int index = maxIndex;
        System.out.print(array[index] +" ");
        while (index>0){
            index = backTrack[index];
            System.out.print(array[index]+ " ");
        }
        System.out.println();

        return max;
    }
}
