# https://leetcode-cn.com/problems/two-sum/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        store = dict()
        for i, num in enumerate(nums):
            if store.get(target - num) is not None:
                return [store[target - num], i]
            else:
                store[num] = i

"""
首先，一眼双指针，O(N^2)的时间复杂度。题目要求低于此时间复杂度。
想到“空间换时间”，通过额外空间记录下每次处理结果，提供给下次处理使用，
考虑到题目要求返回索引，再想到用哈希表记录下(val, idx), 每次迭代优先寻找相应的差值的val
"""
