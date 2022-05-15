class Solution {
    public int findMin(int[] nums) {
        // 相较于非重复版本, 可重复带来的影响是nums开头的可能的重复部分使得nums[i] <= nums[n - 1]可能为 1,.. 0,.. 1
        // 这样就不是递增了. 因此一个可行的思路是先判前面的部分, 跳过从与最后元素相同的元素. 由此退化为非重复版本(中间的重复元素无影响)
        int left = 0, n = nums.length, right = n - 1;
        while (left < right && nums[left] == nums[n - 1]) left++;
        if (left == right) return nums[right];
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[n - 1]) right = mid;
            else left = mid + 1;
        }
        return nums[right];

        // 对时间复杂度的影响取决于最大重复部分长度m. 若m << n, 则还是O(logN), 若 m ~ n, 则退化为O(N)
    }
}
