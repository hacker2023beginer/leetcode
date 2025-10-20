package gpt.leetcode.a33;

public class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //нахожусь в левой части
            if (nums[left] <= nums[mid]) {
                if (nums[left] > target || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > nums[mid] || nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }
}
