package com.company;

/**
 * Created by arun on 8/21/16.
 */
public class Jobs implements Comparable<Jobs>{
    int startTime;
    int endTime;
    int weight;
    public Jobs(int startTime, int endTime, int weight){
        this.startTime = startTime;
        this.endTime = endTime;
        this.weight = weight;
    }

    @Override
    public int compareTo(Jobs j){
        return this.endTime - j.endTime;
    }

    @Override
    public String toString() {
        return "startTime = "+this.startTime+", endTime = "+this.endTime+", weight = "+this.weight;
    }
}
