package com.company;

/**
 * Created by arun on 8/29/16.
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int longestCommonSubSeq = findLongestCommonSubSeq(s1,s2);
        System.out.println("Length of longest common SubSequence is: "+ longestCommonSubSeq);
    }

    public static int findLongestCommonSubSeq(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        int maxI = 0;
        int maxJ = 0;

        for(int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if (max<dp[i][j]){
                    max = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        /*
        Print Actual string.
         */
        int i = maxI;
        int j = maxJ;
        while (dp[i][j]>0){
            if(dp[i][j] != Math.max(dp[i-1][j],dp[i][j-1])){
                System.out.println(s1.charAt(i-1)+" : "+s2.charAt(j-1));
                i--;
                j--;
            }else {
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }
      return max;
    }
}
