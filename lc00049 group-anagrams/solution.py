# https://leetcode-cn.com/problems/group-anagrams/

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        store = dict()
        for str in strs:
            key = ''.join(sorted(str))
            if key not in store:
                store[key] = []
            store[key].append(str)
            
        return [val for _, val in store.items()]

"""
要求返回含有相同字符集的字符串构成的数组, 很容易想到类似哈希表, 根据字符集的构成将字符串映射到数组中, 关键在于如何实现gen_key(str)
这里采用的是将原始字符串排序来构成key. 整个算法的时间复杂度为O(N * M * log M), N为字符串数量, M为字符串的平均长度

优化的话, 应该通过优化gen_key来实现, 即不用排序的M * log M, 尝试降低到O(M), 题解中看到两个比较有意思的思路:
1. 质数积: 给定26个从2开始的质数prime_numbers: List[int], 遍历字符集, 对应的质数累积即为key
2. 频次字符串: 开一个26位数组counts记录字符频次, 各频次字符再使用间隔符合并即为key 类似"0.1.2.1.0"
"""