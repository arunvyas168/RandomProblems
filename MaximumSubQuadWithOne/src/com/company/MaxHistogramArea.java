package com.company;

import java.util.Stack;

/**
 * Created by arun on 9/25/16.
 */
public class MaxHistogramArea {
    public static void main(String[] args) {
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        int maxArea = findMaxArea(histogram);
        System.out.println("Max are for the gven histogram is: "+maxArea);
    }

    /**
     * https://www.youtube.com/watch?v=ZmnqCZp9bBs
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
     * @param histogram
     * @return
     */
    public static int findMaxArea(int[] histogram){
        if (histogram.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        //Start to traverse all elements in array
        while (index<histogram.length){
            int area = 0;
            //if stack is empty or value of next element is greater tha the top of stack
            if ((stack.isEmpty()) ||  (histogram[stack.peek()]<=histogram[index])){
                stack.push(index);
                index++;
            }else {
            // if next value is less tha top of stack;
                int top = stack.pop();
                if (stack.isEmpty()){
                    area = histogram[top]*index;
                }else {
                    area = histogram[top]*(index-stack.peek()-1);
                }
                maxArea = Math.max(area,maxArea);
            // NOTE: dont increase index --- as we keep poping till next index is greater than top
            }
        }

        //Start to pop
        while (!stack.isEmpty()){
            int area = 0;
            int top = stack.pop();
            if (stack.isEmpty()){
                // nothing in stack so we use the entire size of index * top
                area = histogram[top]*index;
            }else {
                // we use (index-next stack top) * top
                area = histogram[top]*(index-stack.peek()-1);
            }
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
