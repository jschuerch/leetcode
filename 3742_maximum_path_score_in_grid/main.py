from typing import List

class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])

        dp = [[[-1]*(k+1) for _ in range(n)] for _ in range(m)]
        dp[0][0][0] = 0

        for i in range(m):
            for j in range(n):
                for c in range(k+1):
                    if dp[i][j][c] == -1:
                        continue
                        
                    if i+1 < m:
                        score = grid[i+1][j]
                        cost = 1 if score > 0 else 0
                        if c + cost <= k:
                            dp[i+1][j][c + cost] = max(dp[i+1][j][c + cost], score + dp[i][j][c])

                    if j+1 < n:
                        score = grid[i][j+1]
                        cost = 1 if score > 0 else 0
                        if c + cost <= k:
                            dp[i][j+1][c + cost] = max(dp[i][j+1][c + cost], score + dp[i][j][c])

        return max(dp[-1][-1])
    


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