# changlog
# 初始化时仅维护底层实际链表, 仅当需要的索引层数超出当前层数时, 增加数层索引. 减少了了不必要的层数.

import random

class Node:
    # 每个值存一个节点, 从有到右为链表顺序, 从上到下稀疏到密集, 底层为实际链表
    def __init__(self, val=None) -> None:
        self.val = val
        self.down = None
        self.right = None

class Skiplist:
    # 向上增加一层索引的概率
    P = 0.5
    # 跳表的最高层数, 方向上, 最底层为实际链表
    MAX_LEVEL = 16
    LEFT_END = -1
    RIGHT_END = 20001

    def __init__(self):
        # 初始化仅存一层
        self.curr_level = 0
        self.head, self.tail = None, None

        self._add_level()
        

    def search(self, target: int) -> bool:
        curr = self.head
        # 比较curr.right的值, 来确定向右还是向下, 而不是curr
        while curr:
            if curr.right.val == target:
                return True
            elif curr.right.val < target:
                curr = curr.right
            elif curr.right.val > target:
                curr = curr.down
        return False
    

    def erase(self, num: int) -> bool:
        curr = self.head
        found = False
        while curr:
            if curr.right.val == num:
                curr.right = curr.right.right
                # 若删除节点后导致当前层为空, 则删除当前层
                if (curr.val == self.LEFT_END and 
                    curr.right.val == self.RIGHT_END and 
                    self.curr_level > 1):
                    self.head, self.tail = self.head.down, self.tail.down
                    self.curr_level -= 1
                curr = curr.down
                found = True
            elif curr.right.val < num:
                curr = curr.right
            elif curr.right.val > num:
                curr = curr.down
        return found


    def add(self, num: int) -> None:
        indexes_level = self._gen_indexes_level()
        # 需要的层数不够, 补层数
        for i in range(indexes_level - self.curr_level):
            self._add_level()

        margin_nodes = []
        curr = self.head
        # 从首层开始向右向下走
        while curr:
            if curr.right.val < num:
                # 右节点还是比num小, 说明当前层没到头, 继续往右走
                curr = curr.right
            else:
                # 右节点大于等于num, 说明在当前节点和右节点间之间插入, 记当前节点为margin_node并下探
                margin_nodes.append(curr)
                curr = curr.down

        pre_node = None
        # 从最底层的margin_node开始, 构建随机层num的节点
        for i in range(self.curr_level - 1, self.curr_level - 1 - indexes_level, -1):
            margin_node = margin_nodes[i]
            node = Node(num)
            node.right = margin_node.right
            margin_node.right = node
            if i < self.curr_level - 1:
                node.down = pre_node
            pre_node = node

    
    # 需要构建的索引数. 最少是1, 即至少要加入到底层的实际链表, 至多较当前层数多维护1层
    def _gen_indexes_level(self) -> int:
        k = 1
        while random.random() < self.P and k <= self.curr_level and k < self.MAX_LEVEL:
            k += 1
        return k

    def _add_level(self) -> None:
        head, tail = Node(self.LEFT_END), Node(self.RIGHT_END)
        head.right = tail
        head.down, tail.down = self.head, self.tail
        self.head, self.tail = head, tail
        self.curr_level += 1
