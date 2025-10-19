package gpt.leetcode.a35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int resultIndex = 0;
        int leftPointer = 0, rightPointer = nums.length - 1, mid;
        while (leftPointer <= rightPointer) {
            mid = (leftPointer + rightPointer) / 2;
            if (nums[mid] == target) {return mid;}
            if (nums[mid] < target) {
                leftPointer = mid + 1;
                resultIndex = mid + 1;
            }
            else {
                resultIndex = mid;
                rightPointer = mid - 1;
            }
        }
        return resultIndex;
    }
}
