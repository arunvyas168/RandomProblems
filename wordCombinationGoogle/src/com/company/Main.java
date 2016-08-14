package com.company;

import java.util.Arrays;

/**
 *  google-interview-questions
 Given a length n, return the number of strings of length n that can be made up of the letters 'a', 'b', and 'c',
 where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's

 Example:
 findStrings(3) returns 19
 since the possible combinations are: aaa,aab,aac,aba,abc,aca,acb,baa,bac,bca,caa,cab,cac,cba,cbc,acc,bcc,cca,ccb
 and the invalid combinations are:
 abb,bab,bba,bbb,bbc,bcb,cbb,ccc
 */

public class Main {

    public static void main(String[] args) {
        char[] input = {'a', 'b', 'c'};
        int window = 3;
        int[] count = new int[input.length];
        Arrays.fill(count,window);
        char[] result = new char[input.length];
        printCombination(input,count,result,0,window);
    }

    public static void printCombination(char[] input, int[] count, char[] result, int level, int window){
        if (level == window){
            printIfValidCombo(result,window);
            return;
        }

        for (int i=0;i<count.length;i++){
            if (count[i] == 0){
                continue;
            }
            result[level] = input[i];
            count[i]--;
            printCombination(input,count,result,level+1,window);
            count[i]++;
        }
    }

    public static void printIfValidCombo(char[] result, int window){
        if (isValidCombo(result,window)){
            for (int i=0;i<window;i++){
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }

    public static boolean isValidCombo(char[] result, int window){
        int bCount = 0;
        for (int i=0;i<window;i++){
            if (result[i] == 'b'){
                bCount++;
            }
            if (result[i] == 'c'){
                if (i+2<window){
                    if ((result[i+1] == 'c')&&(result[i+2] == 'c')){
                        return false;
                    }
                }
            }
        }

        if (bCount>1){
            return false;
        }else {
            return true;
        }
    }

}




