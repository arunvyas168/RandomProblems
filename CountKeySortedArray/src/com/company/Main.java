package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 3};
        int key = 3;
        int count = binarySearchCount(array,key);
        System.out.println("Count of the given key: "+key+" is: "+count);
    }

    public static int binarySearchCount(int[] array, int key){
        int firstOccurrence = searchFirstOccurrence(array,0,array.length-1,key);
        int lastOccurrence = searchLastOccurrence(array,0,array.length-1,key);
        if((firstOccurrence!=-1)&&(lastOccurrence!=-1)){
            return lastOccurrence-firstOccurrence+1;
        }else {
            return 0;
        }

    }

    public static int searchFirstOccurrence(int[]array, int start, int end, int key){
        if(end>=start){
            int mid = start + (end-start)/2;
            /*
                Here we check if the key is at index 0 OR
                if this is the fist occurrence
                AND
                if the elemnt is actually equal to key
             */
            if((mid ==0 || array[mid]>array[mid-1])&&(array[mid]==key)){
                return mid;
            }else if(array[mid]<key){
                return searchFirstOccurrence(array,mid+1,end,key); // here we check if we have to move right
            }else {
                return searchFirstOccurrence(array,start,mid-1,key); // we know we have to move left
            }
        }
        return -1;
    }

    public static int searchLastOccurrence(int[]array, int start, int end, int key){
        if(end>=start){
            int mid = start + (end-start)/2;
            if ((mid==array.length-1 || array[mid]<array[mid+1])&&(array[mid]==key)){
                return mid;
            }else if(array[mid]>key){
                return searchLastOccurrence(array,start,mid-1,key);
            }else {
                return searchLastOccurrence(array,mid+1,end,key);
            }
        }
        return -1;
    }

}
