package p0034_find_first_last_pos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

record TestCase(int[] nums, int target, int[] expected) {};

class FirstLastPositionTest {

    @Test
    void example() {
        FirstLastPosition solution = new FirstLastPosition();

        TestCase[] testCases = {
                new TestCase(new int []{5,7,7,8,8,10}, 8, new int[]{3,4}),
                new TestCase(new int []{5,7,7,8,8,10}, 6, new int[]{-1,-1}),
                new TestCase(new int []{}, 0, new int[]{-1,-1})
        };

        for (TestCase tc : testCases) {
            int[] result = solution.searchRange(tc.nums(), tc.target());
            System.out.println(Arrays.toString(tc.expected()));
            System.out.println(Arrays.toString(result));
            assertArrayEquals(tc.expected(), result);
            //assertArrayEquals(tc.expected(), solution.searchRange(tc.nums(), tc.target()));
        }

    }

}