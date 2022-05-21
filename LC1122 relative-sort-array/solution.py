class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        order_map = {}
        for i, num in enumerate(arr2):
            order_map[num] = i
        def get_order(num):
            if num in order_map:
                return order_map[num]
            order = num + len(arr2)
            # 新的num存一下order
            order_map[num] = order
            return order
        arr1.sort(key=get_order)
        return arr1
