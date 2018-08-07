class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for x in range(len(nums)):
            z = target-nums[x]
            if z in nums[x+1:len(nums)]:
                return [x,nums[x+1:len(nums)].index(z)+x+1]
        return []
