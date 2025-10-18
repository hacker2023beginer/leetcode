package gpt.leetcode.a14longestCommonPrefix;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder(strs[0]);
        int prefixLength = stringBuilder.length();
        for (int i = 1; i < strs.length; i++){
            if (strs[i].length() < prefixLength){
                stringBuilder.delete(strs[i].length(), prefixLength + 1);
                prefixLength = strs[i].length();
            }
            while ((!stringBuilder.toString().equals(strs[i].substring(0, prefixLength))) && (prefixLength != 0)){
                prefixLength--;
                stringBuilder.delete(prefixLength, prefixLength + 1);
            }
            if (prefixLength == 0) break;
        }
        return stringBuilder.toString();
    }
}
