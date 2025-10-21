package gpt.leetcode.a34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        search(nums, target, list, 0);
        if (list.size() == 0) return new int[]{-1, -1};
        if (list.size() == 1) {
            list.add(list.get(0));
            return list.stream().mapToInt(i -> i).sorted().toArray();
        }
        list.sort(Integer::compareTo);
        int[] result = new int[]{list.get(0), list.get(list.size() - 1)};
        Arrays.sort(result);
        return result;
    }

    public void search(int[] nums, int target, List list, int summaryIndex) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                list.add(mid + summaryIndex);
                search(Arrays.copyOfRange(nums, 0, mid), target, list, summaryIndex);
                search(Arrays.copyOfRange(nums, mid + 1, nums.length), target, list, summaryIndex + mid + 1);
                return;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

}
