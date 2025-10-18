package gpt.leetcode.a15sum;
import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int j = i + 1;
        int k = nums.length - 1;
        while (i < k - 1) {
            if (i > 0 && nums[i] == nums[i - 1]){
                i++;
                continue;
            }
            /**
             * будут условия когда дают сумму то добавить,
             * если сумма < 0 то двигаем j
             * иначе двигать k
            */
            while (j != k){
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                else if (nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                else {
                    k--;
                }
            }
            i++;
            k = nums.length - 1;
            j = i + 1;
        }
        return result;
    }
}