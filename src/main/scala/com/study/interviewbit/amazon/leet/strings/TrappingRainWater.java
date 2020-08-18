package com.study.interviewbit.amazon.leet.strings;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * @author andrii_lytvynskyi
 */
public class TrappingRainWater {

   public static int trapWithStack(int[] height) {
       int ans = 0;
       int current = 0;
       Stack<Integer> st = new Stack<>();
       while (current < height.length){
           while (!st.empty() && height[current] > height[st.firstElement()]) {
               int top = st.pop();
                if (st.isEmpty()){
                    break;
                }
               int distance = current - st.firstElement() - 1;
               int bounded_height = Math.min(height[current], height[st.firstElement()]) - height[top];
               ans += distance * bounded_height;
           }
           st.push(current ++);
       }
       return ans;
   }

    public static int trap(int[] height) {
        //Find maximum height of bar from the left end upto an index i in the array left_max\text{left\_max}left_max.
        int length = height.length;
        int ans = 0;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i ++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        //Find maximum height of bar from the right end up to an index i in the array right_max\text{right\_max}right_max.
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < length - 1; i ++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(trapWithStack(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}
