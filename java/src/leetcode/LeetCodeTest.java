package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
