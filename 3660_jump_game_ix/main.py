from typing import List

class Solution:
    def maxValue(self, nums: List[int]) -> List[int]:
        n = len(nums)
        
        # calculate premax_i = max(nums_0 ... nums_i)
        premax = [0] * n
        premax[0] = nums[0]
        for i in range(1, n):
            premax[i] = max(premax[i-1], nums[i])

        # calculate sufmin_i = min(nums_i ... nums_n)
        sufmin = [0] * n
        sufmin[-1] = nums[-1]
        for i in range(n-2, -1, -1):
            sufmin[i] = min(nums[i], sufmin[i+1])

        res = [0] * n
        res[-1] = premax[-1]
        for i in range(n-2, -1, -1):
            # if max value on the left (including current) 
            # is bigger than min value on the right, 
            # current element stays in same section as the element to its right
            if premax[i] > sufmin[i+1]:
                res[i] = res[i+1]
            # otherwise, new disconnected section starts
            else:
                res[i] = premax[i]

        return res
    

if __name__ == "__main__": 
    sol = Solution()
    test_cases = [
            ([2,1,3], [2,2,3]),
            ([2,3,1], [3,3,3]),
            ([12,18,19], [12,18,19]),
            ([2,4,1,3,6,8,7], [4,4,4,4,6,8,8]),
            ([1], [1]),
            ([2,1,4,3,6,7], [2,2,4,4,6,7])
        ]
    for nums, expected in test_cases:
        result = sol.maxValue(nums)
        print(f"Input: nums={nums}, Expected: {expected}, Got: {result}")
        assert result == expected, f"Test failed for input nums={nums}: expected {expected}, got {result}"
