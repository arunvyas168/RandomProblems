package com.company;

import java.util.HashSet;

/**
 * Created by arun on 9/3/16.
 */
public class WordBreakProblem {
    public static void main(String[] args) {
        String str = "IAMACE";
        HashSet<String> dict = new HashSet<>();
        dict.add("I");
        dict.add("A");
        dict.add("AM");
        dict.add("ACE");
        boolean isValidWord = wordBreak(str,dict);
        System.out.println(isValidWord);
    }

    public static boolean wordBreak(String str, HashSet<String> dict){
        String[] array = str.split("");
        int[][]dp = new int[array.length][array.length];

        //Initialize the matrix with -1 for computations
        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[i].length ; j++){
                dp[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }


        for (int len=1;len<=array.length;len++){
            for (int i=0;i<array.length-len+1;i++){
                int j = i+len-1;
                String temp = str.substring(i,j+1);
                if (dict.contains(temp)){
                    dp[i][j] = i;
                }else {
                    for (int k=i+1;k<=j;k++){
                        if ((dp[i][k-1]!= -1)&&(dp[k][j]!=-1)){
                            dp[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }


        //Reconstruct the words
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = str.length() -1;
        while(i < j){
            int k = dp[i][j];
            if(i == k){
                buffer.append(str.substring(i, j+1));
                break;
            }
            buffer.append(str.substring(i,k) + " ");
            i = k;
        }
        System.out.println(buffer.toString());




        return dp[0][array.length-1]!=-1;
    }

}
