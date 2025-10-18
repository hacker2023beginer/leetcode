package gpt.leetcode.a11water;
import java.lang.Math;

public class Solution {
    public int maxArea(int[] height) {
        int left_index = 0;
        int right_index = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        int maxHeight;
        while (left_index < right_index) {
            maxHeight = Math.min(height[left_index], height[right_index]);
            int newMaxArea = maxHeight * (right_index - left_index);
            if (newMaxArea > maxArea){
                maxArea = newMaxArea;
            }
            if (height[left_index] < height[right_index]){
                left_index++;
            }
            else {
                right_index--;
            }
        }
        return maxArea;
    }
}
