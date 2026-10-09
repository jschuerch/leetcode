package p0005_longest_palindrome;

public class LongestPalindrome {

    // p0005
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxlen = 1;
        int start = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ((j == i - 1 || dp[i-1][j+1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (maxlen < i - j + 1) {
                        maxlen = i - j + 1;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start, start + maxlen);
    }


}