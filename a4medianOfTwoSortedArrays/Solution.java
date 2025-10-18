package gpt.leetcode.a4medianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
**/
public class Solution {
    private static List<String> array = new ArrayList<>(Arrays.asList("string", "anotherString"));

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = len1;
        int part1, part2, max_left1 = 0, max_left2, min_right1, min_right2;
        double result = 0;
        while (left <= right){
            part1 = (right + left) / 2;
            part2 = (len1 + len2 + 1) / 2 - part1;
            max_left1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            max_left2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            min_right1 = (part1 == len1) ? Integer.MAX_VALUE : nums1[part1];
            min_right2 = (part2 == len2) ? Integer.MAX_VALUE : nums2[part2];
            if ((max_left1 <= min_right2) && (max_left2 <= min_right1)){
                if ((len1 + len2) % 2 == 0){
                    result = (double) (Integer.max(max_left1, max_left2) + Integer.min(min_right1, min_right2)) / 2;
                    break;
                }
                else {
                    result = (double) Integer.max(max_left1, max_left2);
                    break;
                }
            }
            else if (max_left1 <= min_right2){
                left = part1 + 1;
            }
            else {
                right = part1 - 1;
            }
        }

        return result;
    }
}

