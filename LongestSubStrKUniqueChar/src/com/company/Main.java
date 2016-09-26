package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    String input = "abcbbbbcccbdddadacb";
        int k = 2;
        int longestSubString = longestSubStringwithKUnique(input,k);
        System.out.println("Length of longest SubString with K unique char is: "+longestSubString);
    }

    public static int longestSubStringwithKUnique(String input, int k){
        Set<Character> set = new HashSet<Character>();
        char[] array = input.toCharArray();
        int index = 1;
        int maxLen = 0;
        int len = 0;
        for (char c : array){
            if (set.contains(c)){
                len++;
            }else {
                if (index<k){
                    set.add(c);
                    index++;
                    len++;
                }else {
                    maxLen = Math.max(len,maxLen);
                    len = 1;
                    index = 1;
                    set.clear();
                    set.add(c);
                }
            }
        }
        return Math.max(len,maxLen);
    }
}
