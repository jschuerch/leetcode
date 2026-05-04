
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n >> 1):
            for j in range(i, n - 1 - i):
                x1, y1 = i,       j
                x2, y2 = n-1-j,   i
                x3, y3 = n-1-i,     n-1-j
                x4, y4 = j,       n-1-i
            
                temp = matrix[x1][y1] 
                matrix[x1][y1] = matrix[x2][y2] 
                matrix[x2][y2] = matrix[x3][y3] 
                matrix[x3][y3] = matrix[x4][y4] 
                matrix[x4][y4] = temp 
        
if __name__ == "__main__":
    sol = Solution()
    test_cases = [
            ([[1,2,3],[4,5,6],[7,8,9]], [[7,4,1],[8,5,2],[9,6,3]]),
            ([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], [[13,9,5,1],[14,10,6,2],[15,11,7,3],[16,12,8,4]]),
            ([[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]], [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]),
            ([[1]], [[1]]),
            ([[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]], [[21,16,11,6,1],[22,17,12,7,2],[23,18,13,8,3],[24,19,14,9,4],[25,20,15,10,5]])
    ]

    for matrix, expected in test_cases:
        print(f"Input: \t\t{matrix}")
        sol.rotate(matrix)
        print(f"Expected: \t{expected} \nGot: \t\t{matrix}")
        print()
        assert matrix == expected      

