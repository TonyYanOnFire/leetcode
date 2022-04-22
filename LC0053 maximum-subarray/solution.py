# https://leetcode-cn.com/problems/maximum-subarray/

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        methods = ['greedy', 'DP', 'DC']
        method = 'greedy'
        
        if method == 'greedy':
            # 计算这样的前缀和: 如果前一个前缀和为负数则丢弃, 取当前值为前缀和; 否则加到当前中, 构成当前前缀和
            pre_sum = nums[0]
            max_sum = nums[0]
            for num in nums[1:]:
                pre_sum = num + max(0, pre_sum)
                max_sum = max(max_sum, pre_sum)
            return max_sum
        # todo
        elif method == 'DP':
            ...
        elif method == 'DC':
            ...

"""
想了一个小时, 一行代码都写不出来. 主要是考虑的时候将维护具体是哪个前缀最长子序列给考虑进去了, 想得比较乱
看了题解, 还有两种思路, 留给以后实现
"""
