class Solution {
    public int[] searchRange(int[] nums, int target) {
        // step1: 确定条件
        // 开始位置: 第一个 >= target 
        // 结束位置: 最后一个 <= target
        // 若结束位置 > 开始位置, 说明无解

        // step4. 可能不存在, 找大, right取n
        int left = 0, right = nums.length;
        int[] ans = new int[2];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // step2. 条件照抄
            // step3. 第一或最后? 第一要左, right = mid / left = mid + 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        ans[0] = right;

        // step4. 可能不存在, 找小, left取-1
        left = -1;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // step2. 条件照抄 
            // step3. 最后要右, left = mid / right = mid - 1; 看到mid - 1, mid改上取整
            if (nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        ans[1] = right;
        if (ans[0] > ans[1]) return new int[] {-1, -1};
        return ans;
    }
}