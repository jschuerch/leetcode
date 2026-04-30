import numpy as np
from typing import List

class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = np.empty((m, n), dtype=object)

        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    dp[i][j] = {0:0} if grid[i][j] == 0 else {1:grid[i][j]}
                else:
                    dp[i][j] = {}
                    # check top and left cells and update dp[i][j] accordingly
                    for di, dj in [(-1, 0), (0, -1)]:
                        ni, nj = i + di, j + dj
                        if 0 <= ni < m and 0 <= nj < n:
                            for prev_k, prev_score in dp[ni][nj].items():
                                # add cost + 1 if non score
                                new_k = prev_k + 1 if grid[i][j] > 0 else prev_k
                                if new_k <= k:
                                    # if new_k already exists, take maximum of the two scores
                                    dp[i][j][new_k] = max(dp[i][j].get(new_k, 0), prev_score + grid[i][j])

        dp_final = dp[m-1][n-1]
        if dp_final:
            return max(dp_final.values())
        return -1
    


if __name__ == "__main__": 
    sol = Solution()
    test_cases = [
            ([[0, 1],[2, 0]], 1, 2),
            ([[0, 1],[1, 2]], 1, -1)
        ]
    for grid, k, expected in test_cases:
        result = sol.maxPathScore(grid, k)
        print(f"Input: grid={grid}, k={k}, Expected: {expected}, Got: {result}")
        #assert result == expected, f"Test failed for input grid={grid}, k={k}: expected {expected}, got {result}"