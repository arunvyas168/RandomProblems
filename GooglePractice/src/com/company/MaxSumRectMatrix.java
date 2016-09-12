package com.company;

/**
 * Created by arun on 8/30/16.
 *
 * Wrong Answer Right Approach fix later
 */
public class MaxSumRectMatrix {

    public static class Range{
        int currentSum = 0;
        int start = 0;
        int end = 0;
        public Range(){}
    }

    public static void main(String[] args) {
        int[][] matrix = {
                        {1, 2, -1, -4, -20},
                        {-8, -3, 4, 2, 1},
                        {3, 8, 10, 1, 3},
                        {-4, -1, 1, 7, -6}
                        };
        int maxSumRect = findRectWithMaxSum(matrix);
        System.out.println("The rect with max sum is: "+maxSumRect);
    }

    public static int findRectWithMaxSum(int[][]matrix){

        Range range = new Range();
        int[] dp = new int[matrix.length];
        int maxSum;
        int maxLeft;
        int maxRight;
        int maxUp;
        int maxDown;

        //initialize the variables and dp array
        for(int i=0;i<dp.length;i++){
            dp[i] = matrix[i][0];
        }
        System.out.println();
        getMaxSumSubArray(dp,range);
        maxSum = range.currentSum;
        maxLeft = 0;
        maxRight = 0;
        maxUp = range.start;
        maxDown = range.end;

        for (int left=0;left<matrix[0].length;left++){
            for(int i=0;i<dp.length;i++){
                dp[i] = 0;
            }
            for (int right=left;right<matrix[0].length;right++){
                for(int i=0;i<dp.length;i++){
                    dp[i] = matrix[i][right]+dp[i];
                    getMaxSumSubArray(dp,range);
                    if (maxSum<range.currentSum){
                        maxLeft = left;
                        maxRight = right;
                        maxUp = range.start;
                        maxDown = range.end;
                    }
                }
            }
        }



        System.out.println("The rectangle is: top-"+maxUp+", down-"+maxDown+", right-"+maxRight+
                                                                " left-"+maxLeft);
        return maxSum;
    }

    public static void getMaxSumSubArray(int[] array, Range range){
        int maxSum = array[0];
        int currSum = array[0];
        int start = 0;
        int end = 0;
        for (int i=1;i<array.length;i++){
            //currSum = Math.max(currSum+array[i],array[i]);
            if (array[i]> array[i]+currSum){
                currSum = array[i];
                start = i;
            }else {
                currSum = array[i]+currSum;
            }
            //maxSum = Math.max(currSum,maxSum);
            if (maxSum<currSum){
                maxSum = currSum;
                end = i;
            }
        }
        range.start = start;
        range.end = end;
        range.currentSum = maxSum;
    }

}
