package gpt.leetcode.a16threesum;

import java.util.Arrays;

/**
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int i = 0, j = i + 1, k = nums.length - 1;
        int currentSum;
        while (i <= k - 2){
            while ((j < k) && (j < nums.length)){
                currentSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)){
                    closestSum = currentSum;
                    if (target - currentSum < 0) k--;
                    else if (target - currentSum > 0) j++;
                    else return closestSum;
                }
                else if (target - currentSum < 0){
                    k--;
                }
                else if (target - currentSum > 0){
                    j++;
                }
                else{
                    return closestSum;
                }
            }
            i++;
            k = nums.length - 1;
            j = i + 1;
        }
        return closestSum;
    }
}
