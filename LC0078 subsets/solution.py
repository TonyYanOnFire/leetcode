class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
      if False:
        # 动归?
        q=[[]]
        n=len(nums)
        for i in range(n):
            for j in range(len(q)):
                q.append(q[j]+[nums[i]])
        return q


      """
      想象一个树状的判断流程, 每一层判断num[i]是否需要加入到选择集中, 全部进行判断后, 将选择集纳入答案集
      所以有递归函数r(i: int, chose: List[int])
      边界条件: 没有剩余需要处理的数了 i == n
      边界处理 将当选择集纳入答案集
      下钻: r(i + 1, chose) 以及 r(i + 1, chose + [nums[i]])
      """
      self.n = len(nums)
      self.nums = nums
      self.ans = []
      self.r(0, [])
      return self.ans
    

    def r(self, i, chose):
        if i == self.n:
            self.ans.append(chose.copy())
            return
        self.r(i + 1, chose)
        chose.append(self.nums[i])
        self.r(i + 1, chose)
        chose.pop()

"""
就我而言比较难理解的是在r中两次调用了自己
"""
