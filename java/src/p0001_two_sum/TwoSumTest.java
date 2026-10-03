package p0001_two_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void testCase1() {
        TwoSum solution = new TwoSum();

        int[] expected = new int[]{0, 1};
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertArrayEquals(expected, result);
    }

    @Test
    void testCase2() {
        TwoSum solution = new TwoSum();

        int[] expected = new int[]{1, 2};
        int[] result = solution.twoSum(new int[]{3,2,4}, 6);

        assertArrayEquals(expected, result);
    }

    @Test
    void testCase3() {
        TwoSum solution = new TwoSum();

        int[] expected = new int[]{0, 1};
        int[] result = solution.twoSum(new int[]{3,3}, 6);

        assertArrayEquals(expected, result);
    }

}