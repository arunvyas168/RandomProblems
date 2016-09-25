package com.company;

public class Main {

    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "TEST";
        boolean isMatch = KMP(text.toCharArray(),pattern.toCharArray());
        System.out.println(isMatch);
    }

    /**
     * Function to determine patern match
     * @param text
     * @param patt
     * @return
     */
    public static boolean KMP(char[] text, char[] patt){
        int[] matchArray = new int[patt.length];
        //KMP prefix array computation
        computePrefixSuffixArray(patt,matchArray);
        for (int i: matchArray){
            System.out.print(i+" ");
        }
        System.out.println();

        return isMatch(text,patt,matchArray);
    }


    /**
     * This function uses the computed prefix array to compute isMatch.
     * @param text
     * @param patt
     * @param matchArray
     * @return
     */
    private static boolean isMatch(char[] text, char[] patt, int[] matchArray){
        int i =0;
        int j=0;
        while (i<text.length){
            if (text[i] == patt[j]){
                if (j==patt.length-1){
                    return true;
                }
                i++;
                j++;
            }else{
                // if not a match check if j!= 0. IMPORTANT
                if (j!=0) {
                    j = matchArray[j - 1];
                }else {
                    i++;
                }
            }

        }
        return false;
    }


    /**
     * https://www.youtube.com/watch?v=KG44VoDtsAA
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
     * @param patt
     * @param array
     */
    private static void computePrefixSuffixArray(char[] patt, int[]array){
        if (patt.length == 0){
            return;
        }
        array[0] = 0;
        int i = 1;
        int j = 0;
        while (i<patt.length){
            if (patt[j]==patt[i]){
                array[i] = j+1;
                i++;
                j++;
            }else {
                if (j == 0){
                    array[i] = 0;
                    i++;
                }else {
                    j = array[j-1];
                }
            }
        }
    }
}
