# https://leetcode-cn.com/problems/merge-k-sorted-lists/

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

from typing import List, Optional

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        """
        两两一个分组, 有单个则自成一组, 分组结果为groups
        遍历每个group, 解决一个双有序链表保序合并问题, 只有一个节点的不处理, 结果存入lists
        重复执行上述两个步骤, 直至lists仅包含一个节点, 返回该节点
        O(MlogN) N为lists的长度, M为list平均节点数
        """
        if not lists:
            return None
        while len(lists) != 1:
            groups = []
            for i, list_ in enumerate(lists):
                # print('第{}个list'.format(i))
                # temp = list_
                # while temp is not None:
                #     print(temp.val)
                #     temp = temp.next
                if not i % 2:
                    groups.append([list_])
                else:
                    groups[-1].append(list_)
            lists = []
            for group in groups:
                if len(group) == 2:
                    lists.append(self.merge2List(*group))
                else:
                    lists.append(group[0])
        return lists[0]

    def merge2List(self, list1, list2):
        head = ListNode()
        tail = head
        while list1 is not None or list2 is not None:
            if list2 is None or list1 is not None and list1.val < list2.val:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next
            tail = tail.next
        return head.next

"""
为什么不分成左右两半进行合并？感觉还是没有掌握分治精髓
"""
