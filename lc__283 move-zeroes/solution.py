class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 模板

        # pos = 0
        # for i, num in enumerate(nums):
        #     if ...:
        #         nums[pos] = num
        #         pos += 1
                
        pos = 0
        for num in nums:
          if num != 0:
              nums[pos] = num
              pos += 1
        
        while pos < len(nums):
            nums[pos] = 0
            pos += 1

"""
保序过滤. 按照遍历-操作-判断的解题思路即可
"""