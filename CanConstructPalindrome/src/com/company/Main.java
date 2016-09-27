package com.company;


import java.util.HashSet;
import java.util.Set;

/**
 * google-interview-questions

 Given a string return the longest palindrome that can be constructed by removing or shuffling characters.

 Example:
 'aha' -> 'aha'
 'ttaatta' -> ' ttaaatt'
 'abc' -> 'a' or 'b' or 'c'
 'gggaaa' -> 'gaaag' or 'aggga'

 Note if there are multiple correct answers you only need to return 1 palindrome.
 */

public class Main {

    public static void main(String[] args) {
        String input = "ttaatta";
        String longestPalindrome  = constructPalindrome(input);
        System.out.println("Length of the longest palindrome is: "+longestPalindrome.length()+
                " and value is: "+longestPalindrome);
    }

    //O(n) Time Complexity
    public static String constructPalindrome(String input){
        Set<Character> set = new HashSet<>();
        String prefix = "";
        String suffix = "";
        String mid  = "";
        for (char c : input.toCharArray()){
            if (set.contains(c)){
                prefix += c;
                suffix+=c;
                set.remove(c);
            }else {
                set.add(c);
            }
        }

        if (!set.isEmpty()){
            mid = mid+set.iterator().next();
        }
        return prefix+mid+suffix;
    }



    /*
    public static void printPalindrome(int[] count, char[] str){
        String firstHalf = "";
        String lastHalf = "";
        String middle   = "";
        int oddIndex = -1;
        int oddNum = 0;

        for (int i=0;i<count.length;i++){
            if (count[i]%2 !=0){
                if (oddNum < count[i]){
                    oddNum = count[i];
                    oddIndex = i;
                }
            }else {
                int c = count[i]/2;
                while (c>0){
                    firstHalf += str[i];
                    lastHalf += str[i];
                    c--;
                }
            }
        }

        if (oddIndex!= -1){
            int c = count[oddIndex];
            while (c>0){
                middle += str[oddIndex];
                c--;
            }
        }

        System.out.println("The largest palindrome possible is: "+ firstHalf+middle+lastHalf);
    }


    public static void constructPalindrome(String input){
        Map<Character, Integer> hm = new HashMap<>();
        for(char c : input.toCharArray()){
            if (!hm.containsKey(c)){
                hm.put(c,1);
            }else {
                int val  = hm.get(c);
                hm.put(c,val+1);
            }
        }
        int[] count = new int[hm.size()];
        char[] str = new char[hm.size()];
        Iterator it = hm.entrySet().iterator();
        int i=0;
        for(Map.Entry<Character,Integer> mp : hm.entrySet()){
            count[i] = mp.getValue();
            str[i] = mp.getKey();
            i++;
        }
        printPalindrome(count,str);
    }*/

}
