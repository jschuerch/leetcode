package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCodeTest {

    @Test
    void lengthOfLongestSubstring() {
        LeetCode solution = new LeetCode();
        String s = "eea";
        int expected = 2;
        assertEquals(
                expected,
                solution.lengthOfLongestSubstring(s)
        );
    }

    @Test
    void ValidPalindrome() {
        LeetCode solution = new LeetCode();
        String[] strings = new String[]{
                "A man, a plan, a canal: Panama",
                "race a car",
                ".,",
                "0P"
        };
        boolean[] expected = new boolean[] {
                true,
                false,
                true,
                false
        };
        for (int i = 0; i < strings.length; i++) {
            assertEquals(
                    expected[i],
                    solution.isPalindrome(strings[i])
            );
        }
    }
}
