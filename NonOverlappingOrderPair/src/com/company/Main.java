package com.company;

/**
 *  google-interview-questions

 # take an array and print non over lapping in order pairs. example:

 # [1,2,3,4] => input

 # output below is in order combination

 # (1234)
 # (1)(234)
 # (1)(23)(4)
 # (1)(2)(34)
 # (12)(34)
 # (12)(3)(4)
 # (123)(4)
 # (1)(2)(3)(4)
 *
 */
public class Main {

    public static void main(String[] args) {
        String integer = "1234";
        printNonOverlappingPairs(integer, "");
    }

    public static void printNonOverlappingPairs(String number, String prefix){
        System.out.println (prefix + "(" + number + ")");
        for (int i=1; i<number.length(); i++) {
            String newPrefix = prefix + "(" + number.substring(0, i) + ")";
            String newString = number.substring(i,number.length());
            printNonOverlappingPairs(newString, newPrefix);
        }
    }
}
