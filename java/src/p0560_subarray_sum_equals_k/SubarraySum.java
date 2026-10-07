package p0560_subarray_sum_equals_k;


public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int[] res = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j <= i; j++) {
                res[j] += nums[i];
                if (res[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}