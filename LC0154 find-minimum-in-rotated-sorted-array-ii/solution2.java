public int findMin(int[] nums) {
    int left = 0, n = nums.length, right = n - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] < nums[right]) right = mid;
        else if (nums[mid] > nums[right]) left = mid + 1;
        // nums[mid] == nums[right]时, 无法判定mid左侧还是右侧可能出现min, 但是nums[mid]已经是nums[right]了, 所以我们可以让right向左
        // 也不丢失这个元素
        else right--;
    }
    return nums[right];
}
