package com.company;

/**
 * Created by arun on 8/29/16.
 */
public class MinCostPath2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {  {1, 2, 3},
                            {4, 8, 2},
                            {1, 5, 3}};
        int minCost = findMinCostPath(matrix);
        System.out.println("The min cost to reach from top left to bottom right is: "+ minCost);
    }

    public static int findMinCostPath(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];

        //initialize the dp-matrix
        dp[0][0] = matrix[0][0];
        for (int i=1;i<dp.length;i++){
            dp[i][0] = dp[i-1][0]+matrix[i][0];
        }
        for (int j=1;j<dp[0].length;j++){
            dp[0][j] = dp[0][j-1]+matrix[0][j];
        }

        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                dp[i][j] = Math.min((Math.min(dp[i-1][j], dp[i][j-1])),dp[i-1][j-1])+matrix[i][j];
            }
        }

        return dp[matrix.length-1][matrix[0].length-1];
    }
}
