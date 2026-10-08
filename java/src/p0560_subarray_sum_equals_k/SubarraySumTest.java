package p0560_subarray_sum_equals_k;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


record TestCase(int[] nums, int k, int expected) {}


class SubarraySumTest {

    private TestCase[] testCases = {
        new TestCase(new int[]{1,1,1}, 2, 2),
        new TestCase(new int[]{1,2,3}, 3, 2),
        new TestCase(new int[]{2,-1,3,0,4,5,6,7}, 4, 4),
        new TestCase(new int[]{2,-1,3,0,4,5,6,7}, 2, 3),
        new TestCase(new int[]{2,-1,3,0,4,5,6,7}, 18, 2),
        new TestCase(new int[]{2,-1,3,0,4,-4,1,-1}, 4, 7),
        new TestCase(new int[]{2,-1,3,0,4,-4,1,-1}, 3, 5)
    };

    @Test
    void testCases() {
        SubarraySum subarraySum = new SubarraySum();
        for (TestCase tc : testCases) {
            assertEquals(
                    tc.expected(),
                    subarraySum.subarraySum(tc.nums(), tc.k())
            );
        }
    }

    @Test
    void testCase_n() {
        int i = 5;
        SubarraySum subarraySum = new SubarraySum();
        TestCase tc = testCases[i];
        assertEquals(
                tc.expected(),
                subarraySum.subarraySum(tc.nums(), tc.k())
        );
    }
}