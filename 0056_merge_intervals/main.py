from typing import List

class Solution:
    # time: O(n log n)
    # space: O(n)
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        intervals.sort(key=lambda x: x[0])
        for interval in intervals:
            if not result or result[-1][1] < interval[0]:
                result.append(interval)
            else:
                result[-1][1] = max(result[-1][1], interval[1])
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