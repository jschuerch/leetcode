package p0303_ranged_sum_query;

class NumArray {
    private int[] prefixSums;

    public NumArray(int[] nums) {
        this.prefixSums = new int[nums.length + 1];
        this.prefixSums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSums[right+1] - prefixSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
