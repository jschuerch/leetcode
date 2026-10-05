package p0035_Search_insert_Position;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

record TestCase(int[] nums, int target, int expected) {}

class SearchInsertPositionTest {

    @Test
    void testCases() {
        SearchInsertPosition solution = new SearchInsertPosition();

        TestCase[] testCases = {
                new TestCase(new int[]{1,3,5,6}, 5, 2),
                new TestCase(new int[]{1,3,5,6}, 2, 1),
                new TestCase(new int[]{1,3,5,6}, 7, 4),
        };

        for (TestCase testcase : testCases) {
            assertEquals(
                    testcase.expected(),
                    solution.searchInsert(testcase.nums(), testcase.target())
            );
        }
    }







}