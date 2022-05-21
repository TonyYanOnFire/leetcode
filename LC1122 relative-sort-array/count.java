class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计数排序. 先对arr1计数, 再按arr2顺序输出, 最后按剩余的数据
        int[] counts = new int[1001];
        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int num : arr1) counts[num]++;
        for (int i = 0; i < arr2.length; i++) {
            while (counts[arr2[i]] > 0) {
                ans[idx] = arr2[i];
                idx++;
                counts[arr2[i]]--;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                ans[idx] = i;
                idx++;
                counts[i]--;
            }
        }
        return ans;
    }
}
