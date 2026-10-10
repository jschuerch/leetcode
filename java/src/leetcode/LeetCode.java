package leetcode;

import java.util.*;

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

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // p0021
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    //p0049
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            char[] x = s.toCharArray();
            Arrays.sort(x);
            String key = new String(x);
            anagrams.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagrams.values());
        //return new anagrams.values().stream().toList();
    }
    public List<List<String>> groupAnagramsNoSort(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > 0) {
                    sb.append((char) (i + 'a')).append(cnt[i]);
                }
            }
            String key = sb.toString();
            anagrams.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }


    // p0125
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // p0217
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

    // p0242
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.merge(s.charAt(i), 1, Integer::sum);
            counts.merge(t.charAt(i), -1, Integer::sum);
        }

        for (int count : counts.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }



}
