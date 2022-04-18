# https://leetcode-cn.com/problems/min-stack/

class MinStack:

    def __init__(self):
        self.stack = []
        self.pre_mins = []


    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.pre_mins:
            self.pre_mins.append(min(self.pre_mins[-1], val))
        else:
            self.pre_mins.append(val)


    def pop(self) -> None:
        self.stack = self.stack[:-1]
        self.pre_mins = self.pre_mins[:-1]
        

    def top(self) -> int:
        return self.stack[-1]


    def getMin(self) -> int:
        return self.pre_mins[-1]

"""
考察栈的API, 以及使用前缀数组来储存栈顶信息
"""

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()