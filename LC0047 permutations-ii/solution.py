# https://leetcode-cn.com/problems/permutations-ii/
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        self.nums = nums
        self.n = len(nums)
        self.used = [False] * self.n
        self.chose = []
        self.ans = []
        self.r(0)
        return self.ans
    
    def r(self, pos):
        """
        当前层将数字纳入位置i时，在set中记录该数字。后续的数字，即使没有使用过，却已经插入了i，也不考虑
        """
        if pos == self.n:
            self.ans.append(self.chose.copy())
            return

        placed = set()
        for i in range(self.n):
            if not self.used[i] and self.nums[i] not in placed:
                self.chose.append(self.nums[i])
                self.used[i] = True
                placed.add(self.nums[i])
                self.r(pos + 1)
                self.used[i] = False
                self.chose.pop()

"""
时间复杂度应该没问题，但是不知为何仅击败60%的人。后续考虑全部用java来做
"""
