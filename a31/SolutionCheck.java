package gpt.leetcode.a31;

import gpt.leetcode.a31.Solution;

import java.util.Arrays;

public class SolutionCheck {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = new int[]{2, 3, 1};
        s.nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
}
