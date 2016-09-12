package com.company;

/**
 * Created by arun on 8/30/16.
 */
public class MinimumEditDistance {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        int minEdit = findMinEditDistance(str1,str2);
        System.out.println("The minimum edit needed to make: "+ minEdit);
        String str3 = "abcdef";
        String str4 = "azced";
        minEdit = findMinEditDistance(str3,str4);
        System.out.println("The minimum edit needed to make: "+ minEdit);
    }

    public static int findMinEditDistance(String str1, String str2){
        int[][]dp = new int[str1.length()+1][str2.length()+1];

        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[i].length;j++){
                if (i==0){
                    dp[i][j] = j;
                }else if(j==0){
                    dp[i][j] = i;
                }else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min((Math.min(dp[i-1][j], dp[i][j-1])),dp[i-1][j-1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }
}

