package com.company;

/**
 * Created by arun on 8/30/16.
 */
public class LongestStreakInBinaryArray {
    public static void main(String[] args) {
        int[] array = {1,1,0,0,1,1,1,0,1,1};
        int k = 1;
        int longestStreak = findLongestStreakWithKFlip(array,k);
        System.out.println(longestStreak);
    }

    public static int findLongestStreakWithKFlip(int[] array, int flip){
        int left = 0;
        int right = 0;
        int maxWindow = -1;
        int numZero = 0;

        while (right<array.length){
            if (array[right]==1){
                right++;
            }else {
                if (numZero<flip){
                    numZero++;
                    right++;
                }else {
                    if (array[left]==0){
                        numZero--;
                    }
                    left++;
                }
            }
            if ((right-left)>maxWindow){
                maxWindow = right-left;
            }
        }

        return maxWindow;
    }


}
