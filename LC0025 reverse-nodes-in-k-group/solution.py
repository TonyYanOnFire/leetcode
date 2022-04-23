from hashlib import new
from lib2to3.pytree import Node
from re import L
from tkinter import N
from typing import Optional, Tuple, Union

# Definition for singly-linked list.
class ListNode:
		def __init__(self, val=0, next=None):
				self.val = val
				self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        new_head = None
        new_tail = None
        while head is not None:
            try:
                left, right, next_head = self.split_k_nodes(head, k)
            except ValueError:
                new_tail.next = head
                return new_head

            self.reverse(left)
            left, right = right, left
            # 二者等价
            # right = left
            # left = self.reverse(left)
            
            if new_head is None:
                new_head = left
                new_tail = right
            else:
                new_tail.next = left
                new_tail = right
                
            head = next_head
        return new_head

    def split_k_nodes(self, node, k):
        right_node = node.next
        left_tail = node
        count = 1
        while count < k and right_node is not None:
            left_tail = right_node
            right_node = right_node.next
            count += 1
        if count < k:
            raise ValueError
        if count == k:
            left_tail.next = None
        return node, left_tail, right_node

    def reverse(self, node: ListNode) -> ListNode:
        new_node = None
        while node is not None:
            next = node.next
            node.next = new_node
            new_node = node
            node = next
        return new_node



if __name__ == '__main__':
	s = Solution()

	nums = list(range(10))
	head = None
	tail = None
	for num in nums:
		node = ListNode(val=num)
		if head is None:
			head = node
			tail = node
			continue
		tail.next = node
		tail = node

	# reversed_head = s.reverse(head)
	# r = []
	# while reversed_head is not None:
	# 	r.append(reversed_head.val)
	# 	reversed_head = reversed_head.next
	# print(r)

	# l, f = s.split_k_nodes(head, 2)
	# ll = []
	# while l is not None:
	# 	ll.append(l.val)
	# 	l = l.next
	# print(ll)
	# fl = []
	# while f is not None:
	# 	fl.append(f.val)
	# 	f = f.next
	# print(fl)

	
	l, f = s.split_k_nodes(head, 11)
	ll = []
	while l is not None:
		ll.append(l.val)
		l = l.next
	print(ll)
	print(f is None)


"""
花了1小时才写出来.
需要提升的点:
# 先把思路/步骤理清除, 再写代码. 操作有哪些流程? 用哪些信息来表示分组?
# 对于需要返回新的单链表, 同时处理时要在尾部增加新节点, 使用保护节点技巧:
protect = Node()
last = protect
while ...:
	last.next = ...
	last = ...
"""