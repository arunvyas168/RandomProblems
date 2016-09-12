package com.company;

/**
 * Created by arun on 8/30/16.
 */
public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String str = "gabcnba";
        int longestPalindromicSubSeq = findLongestPalindromicSubSeq(str);
        System.out.println("The longest Palindromic SubSeq is: "+longestPalindromicSubSeq);
    }

    public static int findLongestPalindromicSubSeq(String str){
        int[][] dp = new int[str.length()][str.length()];
        //initialize the matrix for length =1;
        for (int i=0;i<str.length();i++){
            dp[i][i] = 1;
        }

        for (int len=2;len<=str.length();len++){
            for (int i=0;i<str.length()-len+1;i++){
                int j = i+len-1;
                if (str.charAt(i)==str.charAt(j)){
                    if (len==2){
                        dp[i][j] = 2;
                    }else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
