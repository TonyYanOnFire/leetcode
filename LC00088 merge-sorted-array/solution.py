# https://leetcode-cn.com/problems/merge-sorted-array/
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        pos = m + n - 1
        i = m - 1
        j = n - 1
        
        while pos >= 0:
            if j == -1 or i >= 0 and nums1[i] > nums2[j]:
                nums1[pos] = nums1[i]
                i -= 1
            else:
                nums1[pos] = nums2[j]
                j -= 1
            pos -= 1

"""
保序遍历. 由于是两个数组, 所以用双指针
注意到nums1的尾部为我们提供了空间, 所以使用倒序遍历
两个需要注意的地方:
1. 取左数组元素的条件为右数组已空, 即j == -1
2. 大小相同, 左数组元素在前, 因此nums1[i] > nums2[j]才取左数组元素(虽然都是int, 对结果没有影响)
"""