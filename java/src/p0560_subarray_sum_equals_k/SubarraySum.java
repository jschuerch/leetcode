package p0560_subarray_sum_equals_k;


import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFreq = new HashMap<Integer, Integer>();
        prefixFreq.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            count += prefixFreq.getOrDefault(sum - k, 0);
            prefixFreq.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}