package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode {

    // p0003
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Set<Character> seen = new HashSet<>();
        int longest = 0;
        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            longest = Math.max(longest, seen.size());
        }
        return longest;
    }

    // p0005
    public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (checkPalindrome(start, start + length - 1, s)) {
                    return s.substring(start, start + length);
                }
            }
        }
        return "";
    }

    private boolean checkPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // p2017
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}
