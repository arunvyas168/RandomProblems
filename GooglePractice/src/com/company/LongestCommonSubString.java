package com.company;

/**
 * Created by arun on 8/30/16.
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "aOldSite:GeeksforGeeks.org";
        String s2 = "aNewSite:GeeksQuiz.com";
        int longestCommonSybString = findLongestCommonSybString(s1,s2);
        System.out.println("Longest Common Substring is: "+longestCommonSybString);
    }
    public static int findLongestCommonSybString(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        int[] maxIndex = new int[2];
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = 0;
                }
                if (max<dp[i][j]){
                    max = dp[i][j];
                    maxIndex[0] = i;
                    maxIndex[1] = j;
                }
            }
        }


        /*
        Print the actual Solution:
         */
        int value = max;
        int i = maxIndex[0];
        int j = maxIndex[1];
        while (value>0){
            System.out.println(s1.charAt(i-1)+" : "+s2.charAt(j-1));
            value = dp[i-1][j-1];
            i--;j--;
        }
        System.out.println();


        return max;
    }
}
