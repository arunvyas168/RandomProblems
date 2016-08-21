package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Jobs> list = new ArrayList<Jobs>();
        list.add(new Jobs(6,7,4));
        list.add(new Jobs(2,5,6));
        list.add(new Jobs(1,3,5));
        list.add(new Jobs(4,6,5));
        list.add(new Jobs(5,8,11));
        list.add(new Jobs(7,9,2));
        Collections.sort(list);
        int maxWeight = findMaxWeightPossible(list);
        System.out.println(maxWeight);
    }

    public static int findMaxWeightPossible(List<Jobs> list){
        int[] dp = new int[list.size()];
        int index = 0;
        for (Jobs j : list){
            dp[index] = j.weight;
            index++;
        }

        for(int i= 1; i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(list.get(j).endTime<=list.get(i).startTime){
                    dp[i] = Math.max(dp[i],(list.get(i).weight+dp[j]));
                }
            }
        }
        int maxWeight = 0;
        for (int i : dp){
            if(i>maxWeight){
                maxWeight = i;
            }
        }

        return maxWeight;
    }

}
