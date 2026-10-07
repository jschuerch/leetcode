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
        new TestCase(new int[]{2,-1,3,0,4,5,6,7}, 18, 2)
    };

    @Test
    void testCase0() {
        SubarraySum subarraySum = new SubarraySum();
        TestCase tc = testCases[0];
        assertEquals(
                tc.expected(),
                subarraySum.subarraySum(tc.nums(), tc.k())
        );
    }
    @Test
    void testCase1() {
        SubarraySum subarraySum = new SubarraySum();
        TestCase tc = testCases[1];
        assertEquals(
                tc.expected(),
                subarraySum.subarraySum(tc.nums(), tc.k())
        );
    }
    @Test
    void testCase2() {
        SubarraySum subarraySum = new SubarraySum();
        TestCase tc = testCases[2];
        assertEquals(
                tc.expected(),
                subarraySum.subarraySum(tc.nums(), tc.k())
        );
    }
    @Test
    void testCase3() {
        SubarraySum subarraySum = new SubarraySum();
        TestCase tc = testCases[3];
        assertEquals(
                tc.expected(),
                subarraySum.subarraySum(tc.nums(), tc.k())
        );
    }
    @Test
    void testCase4() {
        SubarraySum subarraySum = new SubarraySum();
        TestCase tc = testCases[4];
        assertEquals(
                tc.expected(),
                subarraySum.subarraySum(tc.nums(), tc.k())
        );
    }
}