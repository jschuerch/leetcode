class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in dict:
                return [i, dict[complement]]
            dict[nums[i]] = i
        print(dict)
        return []
        