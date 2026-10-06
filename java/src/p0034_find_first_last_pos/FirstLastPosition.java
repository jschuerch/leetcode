package p0034_find_first_last_pos;

public class FirstLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int start = findBoundary(nums, target, true);

        if (start == -1) {
            return new int[]{-1, -1};
        }

        int end = findBoundary(nums, target, false);

        return new int[]{start, end};
    }

    private int findBoundary(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                result = middle;
                if (findFirst) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

}