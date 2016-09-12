package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by arun on 8/30/16.
 */
public class WeightJobScheduling {

    public static class Job implements Comparable<Job>{
        int startTime;
        int endTime;
        int weight;
        public Job(int startTime, int endTime, int weight){
            this.startTime = startTime;
            this.endTime = endTime;
            this.weight = weight;
        }

        @Override
        public int compareTo(Job o){
            return this.startTime-o.startTime;
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(6,7,4));
        jobs.add(new Job(5,8,11));
        jobs.add(new Job(7,9,2));
        jobs.add(new Job(1,3,5));
        jobs.add(new Job(2,5,6));
        jobs.add(new Job(4,6,5));
        Collections.sort(jobs);
        int maxWeight =  weightedJobSchedulingMaximumProfit(jobs);
        System.out.println("The max weight that i can get is: "+ maxWeight);
    }

    public static int weightedJobSchedulingMaximumProfit(List<Job> jobs){
        int[] dp = new int[jobs.size()];
        int maxSum = 0;
        //initialize the array
        for (int i=0;i<dp.length;i++){
            dp[i] = jobs.get(i).weight;
        }

        for (int i=1;i<dp.length;i++){
            for (int j=0; j<i;j++){
                if (jobs.get(j).endTime<=jobs.get(i).startTime){
                    dp[i] = Math.max(dp[i],jobs.get(i).weight+dp[j]);
                    if (maxSum < dp[i]){
                        maxSum = dp[i];
                    }
                }
            }
        }

        return maxSum;
    }


}


