from typing import List

class Solution:
    # time: O(n log n)
    # space: O(n)
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        intervals.sort()
        i = 1
        current = intervals[0]
        while i < len(intervals):
            if current[1] >= intervals[i][0]:
                current[1] = max(current[1], intervals[i][1])
                i += 1
            else:
                result.append(current)
                current = intervals[i]
        result.append(current)
        return result
            

if __name__ == "__main__": 
    sol = Solution()
    test_cases = [
            ([[1,3],[2,6],[8,10],[15,18]], [[1,6],[8,10],[15,18]]),
            ([[1,4],[4,5]], [[1,5]]),
            ([[4,7],[1,4]], [[1,7]])
        ]
    for x, expected in test_cases:
        result = sol.merge(x)
        print(f"Input: {x}, Expected: {expected}, Got: {result}")
        assert result == expected, f"Test failed for input {x}: expected {expected}, got {result}"