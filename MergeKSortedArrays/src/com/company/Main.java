package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] one = { 1, 3, 5, 7 };
        int[] two = { 2, 4, 6, 8 };
        int[] three = { 0, 9, 10, 11 };
        int[] four = { 0,7};
        int[] k = { 2, 4, 9, 10, 12, 19 };
        List<ArrayContainer> listOfSortedArrays = new ArrayList<>();
        listOfSortedArrays.add(new ArrayContainer(one,0));
        listOfSortedArrays.add(new ArrayContainer(two,0));
        listOfSortedArrays.add(new ArrayContainer(three,0));
        listOfSortedArrays.add(new ArrayContainer(four,0));
        listOfSortedArrays.add(new ArrayContainer(k,0));
        int[] result = mergeKSortedArray(listOfSortedArrays);
        for (int i : result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static int[] mergeKSortedArray(List<ArrayContainer> sortedArrayList){
        int sum = 0;
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
        for(ArrayContainer obj : sortedArrayList){
            pq.add(obj);
            sum += obj.array.length;
        }
        int[] result = new int[sum];
        int index =0;
        while (!pq.isEmpty()){
            ArrayContainer front = pq.poll();
            result[index] = front.array[front.index];
            index++;
            if (front.index < front.array.length-1){
                pq.add(new ArrayContainer(front.array,front.index+1));
            }
        }
        return result;
    }
}
