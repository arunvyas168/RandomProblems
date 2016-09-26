package com.company;

/**
 * Created by arun on 9/25/16.
 */
public class MaxSubSquareWithOne {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1,1,1},
                {1,0,1,1,1},
                {0,1,1,1,1},
                {1,0,1,1,1}
        };
        int subSquareSize = maxSubSquareWithOne(matrix);
        System.out.println(subSquareSize);
    }


    /**
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumSizeSubMatrix.java
     * https://www.youtube.com/watch?v=_Lf1looyJMU
     * @param matrix
     * @return
     */
    public static int maxSubSquareWithOne(int[][]matrix){
        //have array of length column+1
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for (int i =1; i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                //if the value of that column is 0 set to 0;
                if (matrix[i-1][j-1] == 0){
                    dp[i][j] = 0;
                }else {
                    //if value is 1 then set min of all sides +1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    //keep track of max
                    if (max<dp[i][j]){
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
