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

    def __init__(self):
        left = [Node(-1) for _ in range(16)]
        right = [Node(20001) for _ in range(16)]
        for i in range(15):
            left[i].right = right[i]
            left[i].down = left[i + 1]
            right[i].down = right[i + 1]
        left[-1].right = right[-1]
        self.head = left[0]
        

    def search(self, target: int) -> bool:
        curr = self.head
        # 比较curr.right的值, 而不是curr
        while curr:
            if curr.right.val == target:
                return True
            elif curr.right.val < target:
                curr = curr.right
            elif curr.right.val > target:
                curr = curr.down
        return False


    def add(self, num: int) -> None:
        margin_nodes = []
        curr = self.head
        # 从首层开始向右向下走
        while curr:
            if curr.right.val < num:
                # 右节点还是比num小, 说明没到头, 继续往右走
                curr = curr.right
            else:
                # 右节点大于等于num, 说明在当前节点和右节点间之间插入, 记录并下探
                margin_nodes.append(curr)
                curr = curr.down
        
        pre_node = None
        # 从最底层的margin_node开始, 构建随机层num的节点
        for i in range(self.MAX_LEVEL - 1, self.MAX_LEVEL - 1 - self._gen_indexes_level(), -1):
            margin_node = margin_nodes[i]
            node = Node(num)
            node.right = margin_node.right
            margin_node.right = node
            if i < self.MAX_LEVEL - 1:
                node.down = pre_node
            pre_node = node


    def erase(self, num: int) -> bool:
        curr = self.head
        found = False
        while curr:
            if curr.right.val == num:
                curr.right = curr.right.right
                curr = curr.down
                found = True
            elif curr.right.val < num:
                curr = curr.right
            elif curr.right.val > num:
                curr = curr.down
        return found

    
    # 需要构建的索引数. 最少是1, 即至少要加入到底层的实际链表
    def _gen_indexes_level(self) -> int:
        k = 1
        while random.random() < self.P and k < self.MAX_LEVEL:
            k += 1
        return k

