package com.company;

/**
 * Created by arun on 8/30/16.
 */
public class PartitionProblem {
    public static void main(String[] args) {
        int[] array = {3, 1, 5, 9, 12};
        boolean isPartition = partitionProblem(array);
        if (isPartition){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }

    public static boolean partitionProblem(int[] array){
        int sum = 0;
        for (int i : array){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }else {
            return subsetSum(array,sum/2);
        }
    }

    public static boolean subsetSum(int[] array, int sum){
        boolean[][] dp = new boolean[array.length+1][sum+1];

        //Initialize the DP array
        for (int i=0;i<dp[0].length; i++){
            dp[0][i] = true;
        }

        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if (j<array[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = (dp[i-1][j]) || (dp[i-1][j-array[i-1]]);
                }
            }
        }

        return dp[array.length][sum];
    }
}
