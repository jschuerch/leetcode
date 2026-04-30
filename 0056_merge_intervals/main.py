from typing import List

class Solution:
    # Just check all pairs and merge/delete when one is found (order to make sure i is always a lower interval than j)
    # sorting O(n, log(n))
    # loop O(n^2) --> O(n^3) because of the del function
    # space O(n)
    def merge_bruteforce(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        i = 0
        while i < len(intervals):
            j = i + 1
            while j < len(intervals):
                if intervals[i][1] >= intervals[j][0]:
                    if intervals[i][1] < intervals[j][1]:
                        intervals[i][1] = intervals[j][1]
                    del intervals[j]
                else:
                    j += 1
            i += 1
        return intervals
