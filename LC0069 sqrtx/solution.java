class Solution {
    public int mySqrt(int x) {
        // 序列  nums [0, ..., x]
        // 条件 最后一个 num * num <= x
        // 不可能无解
        
        // right初始值除以2后上取整, 不取x是为了避免2^31 - 1爆, 上取整为了处理1
        int left = 0, right = x / 2 + 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid <= x / mid) left = mid;
            else right = mid - 1;
        }
        return right;
    }
}
