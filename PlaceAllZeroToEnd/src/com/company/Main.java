package com.company;

/**
 *  bloomberg-lp-interview-questions

 * Given an unsorted integer array, place all zeros to the end of the array without changing the sequence of non-zero
 * elements. (i.e. [1,3,0,8,12, 0, 4, 0,7] --> [1,3,8,12,4,7,0,0,0])
 */

public class Main {

    public static void main(String[] args) {
        int[] array = {1,3,0,8,12, 0, 4, 0,7};
        reArrangeArray(array);
        for (int i: array){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void reArrangeArray(int[] array){
        int ptr1 = 0;
        int lastNonZero = 0;
        while (ptr1<array.length){
            if (array[ptr1]!=0){
                ptr1++;
            }else {
                int ptr2 = ptr1;
                while ((ptr2<array.length)&&(array[ptr2]==0)){
                    ptr2++;
                }
                if (ptr2<array.length){
                    int temp = array[ptr1];
                    array[ptr1] = array[ptr2];
                    array[ptr2] = temp;
                    ptr1++;
                }else {
                    break;
                }
            }
        }
    }
}
