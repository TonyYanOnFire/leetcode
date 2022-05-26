class Solution {
    public int jump(int[] nums) {
        // 首先检查当前位置能否直接跳到末尾
        // 扫描每个可达位置的最大可达距离, 选取最后一个最大值为下一个位置
        int curr = 0;
        int ans = 0;
        while (curr < nums.length - 1) {
            // 当前最大可达下标到达或超过了末尾元素下标, 则返回ans + 1
            if (curr + nums[curr] >= nums.length - 1) return ans + 1;
            int next = curr + 1;
            for (int nextPos = curr + 1; nextPos <= curr + nums[curr]; nextPos++) {
                // 扫描当前可达下标的最大可达下标
                if (nums[nextPos] + nextPos >= nums[next] + next) next = nextPos;
            }
            curr = next;
            ans++;
        }
        return ans;
    }
}
