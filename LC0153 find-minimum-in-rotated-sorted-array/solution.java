class Solution {
    // public int findMin(int[] nums) {
    //     // 比较nums[i] <= nums[n - 1], 得到0, 0, ... 1, 1
    //     // 问题转化为找到这个非递减数列的第一个1， f(nums[mid]) <= 1

    //     int left = 0, right = nums.length - 1;
    //     while (left < right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] <= nums[nums.length - 1]) {
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     // 注意：若保留一侧，退出循环时左右指针相等（以两个元素为例自行推导），此时返回right，而不是内部变量mid
    //     return nums[right];
    // }


    // 法2：符合条件的等式一边保留mid，并检查mid，记为ans
    // public int findMin(int[] nums) {
    //     int left = 0, right = nums.length - 1, ans = nums.length - 1;
    //     while (left < right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] <= nums[nums.length - 1]) {
    //             ans = Math.min(ans, mid);
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return nums[ans];
    // }


    // 法3：两边都保留mid，循环退出条件改为left + 1 < right避免死循环; 返回时检查left，right
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] <= nums[nums.length - 1]) return nums[left];
        return nums[right];
    }
}
