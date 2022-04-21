# https://leetcode-cn.com/problems/reverse-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        new_head = None
        while head is not None:
            next_ = head.next
            head.next = new_head
            new_head = head
            head = next_

        return new_head

"""
几个指针的交换光靠想比较难想清楚, 画一下图就很清晰了
"""