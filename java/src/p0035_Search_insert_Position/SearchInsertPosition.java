package p0035_Search_insert_Position;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left<=right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}