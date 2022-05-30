class Solution {
    public int maxProfit(int[] prices) {
        // 7, 1, 5, 3, 6, 4
        // 0, 0, 4, 2, 5, 3 差值
        // *, 7, 1, 1, 1, 1 前缀最小值

        // 7, 6, 4, 3, 1
        // *, 7, 6, 4, 3
        // *, -1, -2, -1, -2

        int preMin = prices[0];
        int ans = -1;
        for (int i = 1; i < prices.length; i++) {
            preMin = Math.min(preMin, prices[i - 1]);
            ans = Math.max(ans, prices[i] - preMin);
        }
        return ans < 0 ? 0 : ans;
    }
}
