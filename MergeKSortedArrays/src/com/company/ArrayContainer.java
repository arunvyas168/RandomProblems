package com.company;

import java.util.Comparator;

/**
 * Created by arun on 9/11/16.
 */
public class ArrayContainer implements Comparable<ArrayContainer> {
    int[] array;
    int index;
    public ArrayContainer(){}
    public ArrayContainer(int[] array, int index){
        this.array = array;
        this.index = index;
    }
    @Override
    public int compareTo(ArrayContainer o1){
        return this.array[this.index]-o1.array[o1.index];
    }
}
