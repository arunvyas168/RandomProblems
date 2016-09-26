package com.company;

import java.util.Stack;

/**
 * Created by arun on 9/25/16.
 */
public class MaxSubRectangleWithOne {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,1,1,0},
                {1,1,1,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,0,1},
                {1,1,1,1}};
        int maxRectangle = getMaxRectWithOne(matrix);
        System.out.println(maxRectangle);
    }

    /**
     * https://www.youtube.com/watch?v=g8bSdXCG-lA
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumRectangularSubmatrixOf1s.java
     * @param matrix
     * @return
     */
    public static int getMaxRectWithOne(int[][]matrix){
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        //Initialize the array
        for (int i=0;i<matrix[0].length;i++){
            dp[i] = matrix[0][i];
        }

        int area  = findMaxArea(dp);
        maxArea = Math.max(maxArea,area);

        for (int i=1;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                //if matrix is 0 set dp to 0
                if (matrix[i][j] == 0){
                    dp[j]=0;
                }else {
                    //if matrix is 1 set dp to dp+value;
                    dp[j] = dp[j]+matrix[i][j];
                }
            }
            //use histogram to compute max area
            area = findMaxArea(dp);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }









    private static int findMaxArea(int[] histogram){
        if (histogram.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index<histogram.length){
            int area = 0;
            if ((stack.isEmpty()) ||  (histogram[stack.peek()]<=histogram[index])){
                stack.push(index);
                index++;
            }else {
                int top = stack.pop();
                if (stack.isEmpty()){
                    area = histogram[top]*index;
                }else {
                    area = histogram[top]*(index-stack.peek()-1);
                }
                maxArea = Math.max(area,maxArea);
            }
        }
        while (!stack.isEmpty()){
            int area = 0;
            int top = stack.pop();
            if (stack.isEmpty()){
                area = histogram[top]*index;
            }else {
                area = histogram[top]*(index-stack.peek()-1);
            }
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
