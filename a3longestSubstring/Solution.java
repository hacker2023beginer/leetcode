package gpt.leetcode.a3longestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            String elem = s.substring(i, i + 1);
            if (set.add(elem)){
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                }
                right++;
            }
            else {
                //set.remove(elem);
                String elemOfSet = s.substring(left, left + 1);
                while (!elemOfSet.equals(elem)){
                    set.remove(elemOfSet);
                    left++;
                    elemOfSet = s.substring(left, left + 1);
                }
                //set.remove(elemOfSet);
                left++;
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                }
                right++;
            }
        }
        return maxLength;
    }
}
