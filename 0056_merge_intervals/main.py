from typing import List

class Solution:
    # Sort intervals and merge neighboring intervals if they overlap
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        i = 0
        while i < len(intervals)-1:
            if intervals[i][1] >= intervals[i+1][0]:
                if intervals[i][1] < intervals[i+1][1]:
                    intervals[i][1] = intervals[i+1][1]
                del intervals[i+1]
            else:
                i += 1
        return intervals

