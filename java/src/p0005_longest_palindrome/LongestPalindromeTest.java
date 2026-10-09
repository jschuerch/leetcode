package p0005_longest_palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {

    @Test
    void example() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        assertEquals(
                "bab",
                longestPalindrome.longestPalindrome("babad")
        );
    }
    @Test
    void example2() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        assertEquals(
                "bb",
                longestPalindrome.longestPalindrome("cbbd")
        );
    }

}