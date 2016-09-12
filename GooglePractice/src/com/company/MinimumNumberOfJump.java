package com.company;

import java.util.Arrays;

/**
 * Created by arun on 9/3/16.
 */
public class MinimumNumberOfJump {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int minJump = minJumpToReachEnd(array);
        System.out.println("The minimum number of jump to reach the end: "+minJump);
    }

    public static int minJumpToReachEnd(int[] array){
        int[] jumpArray = new int[array.length];
        int[] actualJump = new int[array.length];
        Arrays.fill(jumpArray,Integer.MAX_VALUE);

        //Initialize the arrays for jum 0-0
        jumpArray[0] = 0;
        actualJump[0] = -1;

        for (int i=1;i<array.length;i++){
            for (int j=0;j<i;j++){
                if (array[j]+j>= i){
                    if ((1+jumpArray[j])< jumpArray[i]){
                        jumpArray[i] = 1+jumpArray[j];
                        actualJump[i] = j;
                    }
                }
            }
        }

        //print the actual path:
        int index = array.length-1;
        System.out.print(array[index]+" ");
        while (index>0){
            index = actualJump[index];
            System.out.print(array[index]+" ");
        }
        System.out.println();

        return jumpArray[array.length-1];
    }
}
