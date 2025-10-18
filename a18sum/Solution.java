package gpt.leetcode.a18sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = i + 1, k = nums.length - 1, l = j + 1;
        while (i < nums.length - 3) {
            while (j < nums.length - 2) {
                while (l < k){
                    if ((long) nums[i] + nums[j] + nums[k] + nums[l] == (long) target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
                        l++;
                        while (l < k && nums[l] == nums[l - 1]) l++;
                        k--;
                        while (l < k && nums[k] == nums[k + 1]) k--;
                    }
                    else if (((long)nums[i] + nums[j] + nums[k] + nums[l] <  (long) target)){
                        l++;
                        while (l < k && nums[l] == nums[l - 1]) l++;
                    }
                    else{
                        k--;
                        while (l < k && nums[k] == nums[k + 1]) k--;
                    }
                }
                j++;
                while (j < nums.length - 2 && nums[j] == nums[j - 1]) j++;
                k = nums.length - 1;
                l = j + 1;
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
            j = i + 1;
            k = nums.length - 1;
            l = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}
