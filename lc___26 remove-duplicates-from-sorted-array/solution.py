# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # 这个答案也对, 只是想法上不是很结构化

        # pos = 0
        # for i, num in enumerate(nums):
        #     if nums[pos] != num:
        #         nums[pos + 1] = num
        #         pos += 1
        # return pos + 1

        pos = 0
        for i, num in enumerate(nums):
            if i == 0 or num > nums[pos - 1]:
                nums[pos] = num
                pos += 1

        return pos

"""
一道保序过滤题. 首先当然是遍历
        for i, num in enumerate(nums): # 1
          ... # 1

然后看一下题目要求返回不重复元素个数k, 用指针pos记录赋值的索引, 每次操作后pos++, 所以最后返回pos即可

        pos = 0 # 2
        for i, num in enumerate(nums):
          nums[pos] = num # 2
          pos += 1 # 2

        return pos # 2

最后增加过滤条件, 即"什么时候操作", 在这里就是"什么时候对pos位置赋值num", 按照题目描述, 自然是值为一路遍历过来的非重复值.
所以首个元素肯定是无条件要的. 另外, 数组是升序的, 因此遍历到的num大于pos指向元素, 就说明这个num肯定和前面的值不重复了.
3.
        pos = 0
        for i, num in enumerate(nums):
            if i == 0 or num > nums[pos - 1]: # 3
                nums[pos] = num
                pos += 1

        return pos
"""
