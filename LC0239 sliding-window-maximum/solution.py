from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = deque() 
        ans = []
        # i为right
        for i in range(len(nums)):
            # 从队尾清除小于num的元素(由于num的加入, 这些元素一定不再是最大值), 再加入num
            while len(q) and q[-1][1] < nums[i]:
                q.pop()
            q.append((i, nums[i]))
            # 滑动窗口到达指定宽度, 开始输出
            if i >= k - 1:
                # 检查队头元素下标是否还有效, 无效则去除队头. 不需要while. 到这里至q长度至多为k + 1
                if q[0][0] < i - k + 1:
                    q.popleft()
                # 此时队头即为滑动窗口最大值
                ans.append(q[0][1])
            
        return ans
