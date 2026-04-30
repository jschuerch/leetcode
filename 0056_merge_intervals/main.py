from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 1:
            return intervals
        result = []
        intervals.sort()
        i = 0
        j = 1
        while i < len(intervals)-1 and j < len(intervals):
            if intervals[i][1] >= intervals[j][0]:
                if intervals[i][1] < intervals[j][1]:
                    intervals[i][1] = intervals[j][1]
                if j == len(intervals)-1:
                    result.append(intervals[i])
                j += 1
            else:
                # interval i is now separate from the intervals j and later
                result.append(intervals[i])
                if j == len(intervals)-1:
                    result.append(intervals[j])
                i = j
                j += 1
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