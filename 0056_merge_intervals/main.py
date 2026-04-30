from typing import List

class Solution:
    # instead of deleting, work with pointers and create new result list
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        intervals.sort()
        i = 0
        j = 1
        while i < len(intervals)-1 and j < len(intervals):
            if intervals[i][1] >= intervals[j][0]:
                if intervals[i][1] < intervals[j][1]:
                    intervals[i][1] = intervals[j][1]
                j += 1
            else:
                # interval i is now separate from the intervals j and later
                result.append(intervals[i])
                i = j
                j += 1
        return result

    # only check neighboring intervals because of sorting
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
