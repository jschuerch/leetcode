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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // p0058
    public int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = merged.get(merged.size() - 1);
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // p0104
    // DFS
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }


    // p0121
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    // p0122
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }

    // DP Variant
    public int maxProfit2_DP(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }

    // Less Memory
    public int maxProfit2_DP2(int[] prices) {
        int profit[] = new int[]{-prices[0], 0};

        for (int i = 1; i < prices.length; i++) {
            int temp[] = new int[2];
            temp[0] = Math.max(profit[0], profit[1] - prices[i]);
            temp[1] = Math.max(profit[1], profit[0] + prices[i]);
            profit = temp;
        }

        return profit[1];
    }

    // p0123
    public int maxProfit3(int[] prices) {
        int[] maxProfitLeft = new int[prices.length];
        int[] maxProfitRight = new int[prices.length];

        int minValue = prices[0];
        int maxValue = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            maxProfitLeft[i] = Math.max(maxProfitLeft[i - 1], prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);

            int j = prices.length - i - 1;
            maxProfitRight[j] = Math.max(maxProfitRight[j + 1], maxValue - prices[j]);
            maxValue = Math.max(maxValue, prices[j]);
        }

        int maxProfit = maxProfitRight[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxProfitLeft[i - 1] + maxProfitRight[i]);
        }

        return maxProfit;
    }

    public int maxProfit3_DP(int[] prices) {
        int f1 = -prices[0]; // Max profit after first purchase
        int f2 = 0; // Max profit after first sale
        int f3 = -prices[0]; // Max profit after second purchase
        int f4 = 0; // Max profit after second sale

        for (int i = 1; i < prices.length; i++) {
            f1 = Math.max(f1, -prices[i]);
            f2 = Math.max(f2, f1 + prices[i]);
            f3 = Math.max(f3, f2 - prices[i]);
            f4 = Math.max(f4, f3 + prices[i]);
        }

        return f4;
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

    // p0206
    public ListNode reverseList(ListNode head) {
        return reverseRecursive(head, null);
    }

    private ListNode reverseRecursive(ListNode node, ListNode reversedHead) {
        if (node == null) {
            return reversedHead;
        }

        ListNode tail = node.next;
        node.next = reversedHead;
        return reverseRecursive(tail, node);
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = reverseList2(head.next); // reversedHead holds reference to reversed sublist...
        // not i need to reverse head and head.next
        head.next.next = head; // create closed loop
        head.next = null; // break loop, not instead of head -> head.next it is head.next -> head
        // and reversedHead holds the reference to "head.next", which is why we return reversedHead
        return reversedHead;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        ListNode newHead = new ListNode();

        while (curr != null) {
            prev = curr;
            curr = curr.next;

            ListNode temp = newHead.next;
            newHead.next = prev;
            prev.next = temp;
        }

        return newHead.next;
    }

    public ListNode reverseList4(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
        if (s.length() != t.length()) {
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

    //p0238
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n + 2];
        int[] suffixProd = new int[n + 2];
        prefixProd[0] = 1;
        prefixProd[n + 1] = 1;
        suffixProd[0] = 1;
        suffixProd[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            prefixProd[i + 1] = prefixProd[i] * nums[i];
            suffixProd[n - i] = suffixProd[n + 1 - i] * nums[n - 1 - i];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProd[i] * suffixProd[i + 2];
        }

        return answer;
    }

    public int[] productExceptSelf_LinearSpace(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;

        // Prefix Products
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Suffix Products
        for (int i = n - 2; i > 0; i--) {
            nums[i] = nums[i] * nums[i + 1];
        }

        // Combine both
        for (int i = 0; i < n - 1; i++) {
            answer[i] = answer[i] * nums[i + 1];
        }

        return answer;
    }

    public int[] productExceptSelf_LinearSpace2(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;

        // Prefix Products
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Calculate Suffix Products and combine with Prefix
        int suffixProd = 1;
        for (int i = n - 1; i > 0; i--) {
            suffixProd *= nums[i];
            answer[i - 1] *= suffixProd;
        }

        return answer;
    }

    //p0347
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int f = entry.getValue();
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }
        int[] answer = new int[k];
        int cnt = 0;
        int i = nums.length;
        while (cnt < k) {
            if (buckets[i] == null) {
                i--;
                continue;
            }
            for (int num : buckets[i]) {
                answer[cnt++] = num;
            }
            i--;
        }

        return answer;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        // O(1)
        if (k == nums.length) {
            return nums;
        }

        // O(n)
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> freq.get(n1) - freq.get(n2));

        // Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: freq.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    // p0704
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
