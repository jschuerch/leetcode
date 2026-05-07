from typing import List

class Solution:
    def maxValue(self, nums: List[int]) -> List[int]:
        n = len(nums)
        
        ans = []
        start = 0
        end = 0
        maxval = 0
        for i in range(n):
            maxval = max(maxval, nums[i])
            for j in range(n - 1, i - 1, -1):
                if nums[j] < nums[i] or j <= end:
                    end = j
                    break
                elif i == j:
                    end = j
                    
            if j == n-1:
                end = j

            if i == end:
                ans += [maxval] * (end - start + 1)
                start = i + 1
        return ans
    

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
