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
        System.out.println("The max weight that I can get is: "+ maxWeight);
        int maxWeightNlogN = weightedJobSchedulingMaximumProfitNLogN(jobs);
        System.out.println("The max weight that I can get is: "+ maxWeightNlogN);
    }

    /**
     * This is the binary search util method to find the latest job
     *       (before current job) that doesn't conflict with current
     *       job.
     * @param jobs
     * @param index
     * @return
     */
    public static int binary_search(List<Job> jobs, int index){
        int low = 0;
        int high = index-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (jobs.get(mid).endTime<=jobs.get(index).startTime){
                if(jobs.get(mid+1).endTime<=jobs.get(index).startTime){
                    low = mid+1;
                }else {
                    return mid;
                }
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    /**
     * This will solve the weighted scheduling problem in O(nLog(n)) time.
     * @param jobs
     * @return
     */
    public static int weightedJobSchedulingMaximumProfitNLogN(List<Job> jobs){
        int[] profit = new int [jobs.size()];
        profit[0] = jobs.get(0).weight;
        for(int i=1;i<jobs.size();i++){
            int includeProfit = jobs.get(i).weight;
            int index = binary_search(jobs,i);
            if (index!=-1){
                includeProfit = includeProfit+profit[index];
            }
            profit[i] = Math.max(includeProfit,profit[i-1]);
        }
        return profit[profit.length-1];
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


