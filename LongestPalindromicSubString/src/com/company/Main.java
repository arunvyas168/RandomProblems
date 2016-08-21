package com.company;

public class Main {

    public static void main(String[] args) {
	    String str = "forgeeksskeegfor";
        int palindromeLen = longestPalindromeSubString(str);
        System.out.println(palindromeLen/2);
    }

    public static int expandForPalindrome(String input, int index){
        if ((index<0)||(index>input.length())){
            return -1;
        }
        int length = 1;
        int left = index-1;
        int right = index+1;
        while((left>=0)&&(right<input.length())){
            if (input.charAt(left)==input.charAt(right)){
                length += 2;
                left--;
                right++;
            }else {
                break;
            }
        }
        return length;
    }

    public static int longestPalindromeSubString(String str){
        String input = handleEvenOdd(str);          //To handle even palindrome
        int maxLen = 0;
        int[] palindromeLen = new int[input.length()];
        for(int i=0;i<input.length();i++){
            palindromeLen[i] = expandForPalindrome(input,i);
            if (maxLen < palindromeLen[i]){
                maxLen = palindromeLen[i];
            }
        }
        return maxLen;
    }

    public static String handleEvenOdd(String str){
        int len = str.length();
        char[] array = new char[(2*len)+1];
        int index = 0;
        for(int i=0;i<array.length;i++){
            if(i%2 == 0){
                array[i] = '$';
            }else {
                array[i] = str.charAt(index);
                index++;
            }
        }
        return new String(array);
    }
}
