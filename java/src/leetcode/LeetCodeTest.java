package leetcode;

import org.junit.jupiter.api.Test;
import leetcode.LeetCode.ListNode;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void binarySearch() {
        LeetCode solution = new LeetCode();
        assertEquals(
                4,
                solution.binarySearch(new int[] { -1, 0, 3, 5, 9, 12}, 9)
        );
    }

    @Test
    void reversesLinkedList() {
        // Arrange: Create [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        LeetCode solution = new LeetCode();

        // Act
        ListNode result = solution.reverseList(head);

        // Assert: Expected [5, 4, 3, 2, 1]
        int[] expected = {5, 4, 3, 2, 1};
        ListNode current = result;

        for (int value : expected) {
            assertNotNull(current, "List ended before all expected values were found");
            assertEquals(value, current.val);
            current = current.next;
        }

        assertNull(current, "List contains more nodes than expected");
    }

}
