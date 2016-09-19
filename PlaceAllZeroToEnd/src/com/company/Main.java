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
        int count=0;
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for(int i=0;i<array.length;i++){
            if (array[i] !=0){
                array[count++]=array[i];    // count is incremented
            }
        }

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < array.length)
            array[count++] = 0;
    }


    /*public static void reArrangeArray(int[] array){
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
    }*/
}
