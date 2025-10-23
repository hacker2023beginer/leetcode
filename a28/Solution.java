package gpt.leetcode.a28;

public class Solution {
    public static int strStr(String haystack, String needle) {
        int resultIndex = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    resultIndex = i;
                    return resultIndex;
                }
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        System.out.println(Solution.strStr("hello", "ll"));
    }
}
