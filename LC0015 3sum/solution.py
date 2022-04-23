# https://leetcode-cn.com/problems/3sum/

from typing import List

class Solution:
  def threeSum(self, nums: List[int]) -> List[List[int]]:
    ans = set()
    for i, num in enumerate(nums):
      two_sums = self.two_sum(nums[:i]  + nums[i + 1:], -num)
      if two_sums:
        for two_sum in two_sums:
          two_sum.append(num)
          two_sum = sorted(two_sum)
          ans.add(tuple(two_sum))
    return [list(_) for _ in ans]

  def two_sum(self, nums, sum=0):
        res = []
        store = {}  # num: used
        for num in nums:
          target = sum - num
          if target in store and not store[target]:
              res.append([num, target] if num <= target else [target, num])
              store[target] = store[num] = True
          else:
              store[num] = False
        return res

if __name__ == "__main__":
    s = Solution()
    # nums = [-1, 0, 2, 1, -1, -1, -4]
    # print(s.two_sum(nums, 1))

    ipt = [-1,0,1,2,-1,-4]
    print(ipt)
    print(s.threeSum([-1,0,1,2,-1,-4]))
    print('\n')

"""
这个版本思路上可行, 但是时空复杂度都很高. 主要原因在于为了不重复进行的两次类型转换
"""