from typing import List

class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        # Prefix/suffix version

        #flatten grid and sort but already check for the remainder:
        #gridlist = [item for subgrid in grid for item in subgrid]
        gridlist = []
        total = 0
        for subgrid in grid:
            for item in subgrid:
                if item % x != grid[0][0] % x:
                    return -1
                gridlist.append(item)
                total += item
        gridlist.sort()

        length = len(gridlist)

        #prefix_sum = [0] * length
        num_ops = [0] * length
        presum = 0
        # fix current value, and calculate how many operations are needed to change to current value
        for i in range(length):
            val = gridlist[i]
            preops = (i * val - presum) // x
            sufops = (total - presum - (length - i) * val) // x
            presum += val
            num_ops[i] = preops + sufops
            if i > 0 and num_ops[i] > num_ops[i-1]:
                return num_ops[i-1]

        return num_ops[-1]
    
    
    def minOperations_use_median(self, grid: List[List[int]], x: int) -> int:
        m = len(grid)
        n = len(grid[0])
        r = grid[0][0] % x
        for i in range(m):
            for j in range(n):
                if r != grid[i][j] % x:
                    return -1
        gridlist = [item for subgrid in grid for item in subgrid]
        median = statistics.median_low(gridlist) #statistics.median_high(gridlist)]
        return sum([abs(g - median) // x for g in gridlist])


if __name__ == "__main__": 
    sol = Solution()
    test_cases = [
            ([[2,4],[6,8]], 2, 4),
            ([[1,5],[2,3]], 1, 5),
            ([[1,2],[3,4]], 2, -1)
        ]
    for grid, x, expected in test_cases:
        result = sol.minOperations(grid, x)
        print(f"Input: {x}, Expected: {expected}, Got: {result}")
        assert result == expected, f"Test failed for input {x}: expected {expected}, got {result}"