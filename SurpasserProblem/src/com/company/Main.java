package com.company;

import java.util.*;

/**
 * google-interview-questions


 The "surpasser" of an element in an array is defined as the number of elements that are to the "right" and bigger than itself.

 Example:
 Array:
 [2, 7, 5, 5, 2, 7, 0, 8, 1]
 The "surpassers" are
 [5, 1, 2, 2, 2, 1, 2, 0, 0]

 Question: Find the maximum surpasser of the array.

 In this example, maximum surpasser = 5
 */


public class Main {
    public static int[] a =  {2, 7, 5, 3, 0, 8, 1};
    public static int[] b = new int[7];
    public static int[] c = new int[7];
    public static int[] t = new int[7];

    public static void main(String[] args) {
        System.out.print("a = [");
        for (int i = 0; i < b.length; i++){
            b[i] = i;
            System.out.print(a[i]+" ");
        }
        System.out.println("]");
        int maxSurpasser = findMaxSurpasser();
        System.out.println(maxSurpasser);
    }

    public static int findMaxSurpasser(){
        mergeSort(0, a.length - 1);
        int max = 0;
        //
        System.out.print("b = [");
        for (int i = 0; i < b.length; i++){
            System.out.print(b[i]+" ");
        }
        System.out.println("]");

        //
        System.out.print("c = [");
        for (int i = 0; i < a.length; i++) {
            if (c[i] > max) {
                max = c[i];
            }
            System.out.print(c[i]+" ");
        }
        System.out.println("]");
        return max;
    }

    public static void mergeSort(int start, int end){
        if(start>=end){
            return;
        }

        int mid = start + (end-start)/2;
        mergeSort(start,mid);
        mergeSort(mid+1,end);

        int low1 = start;
        int low2 = mid+1;
        int count = 0;

        for(int i=start;i<=end;i++){
            if((low2>end) || (low1<=mid && a[b[low1]] >= a[b[low2]])){
                t[i] = b[low1];
                c[b[low1]] += count;
                low1++;
            }else {
                t[i] = b[low2];
                count++;
                low2++;
            }
        }
        for (int i=start;i<=end;i++){
            b[i] = t[i];
        }

    }

}
