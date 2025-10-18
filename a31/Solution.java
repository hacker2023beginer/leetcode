package gpt.leetcode.a31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int numsLength = nums.length;
        int elem;
        if (numsLength == 1) return;
        int leftPointer = numsLength - 2, rightPointer = numsLength - 1, board = 0;
        int nextAfterFirst = Integer.MAX_VALUE;
        int exchIndex = rightPointer;
        while (board <= leftPointer && leftPointer >= 0){
            if (nums[leftPointer] < nums[rightPointer] && leftPointer != 0){
                elem = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = elem;
                board = leftPointer + 1;
                leftPointer = numsLength - 2;
                rightPointer = numsLength - 1;
            }
            else if (nums[leftPointer] < nums[rightPointer] && leftPointer == 0){
                if (nums[0] - nums[rightPointer] < 0 && nums[0] - nextAfterFirst < nums[0] - nums[rightPointer]) {
                    nextAfterFirst = nums[rightPointer];
                    exchIndex = rightPointer;
                }
                elem = nums[leftPointer];
                nums[leftPointer] = nextAfterFirst;
                nums[exchIndex] = elem;
                Arrays.sort(nums, 1, numsLength);
                return;
            }
            else {
                if (nums[0] - nums[rightPointer] < 0 && nums[0] - nextAfterFirst < nums[0] - nums[rightPointer]) {
                    nextAfterFirst = nums[rightPointer];
                    exchIndex = rightPointer;
                }
                leftPointer--;
                rightPointer--;
            }
        }
        if (board == 0){
            leftPointer = 0;
            rightPointer = numsLength - 1;
            while (leftPointer < rightPointer){
                elem = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = elem;
                leftPointer++;
                rightPointer--;
            }
        }
    }
}
