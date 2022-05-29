class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 状态为当前节点的最小路径和. 有s[i][j] = min(s[i-1][j], s[i-1][j-1]) + nums[i][j]
        // 即当前节点的最小路径和是其可能来源(上层左右)的最小路径和的最小值加节点值
        // 实际只需要维护最后一层
        int[] s = {triangle.get(0).get(0)};
        for (int i = 1; i < triangle.size(); i++) {
            int[] ns = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                ns[j] = triangle.get(i).get(j);
                if (j == 0) ns[j] += s[0];
                else if (j == i) ns[j] += s[j - 1];
                else ns[j] += Math.min(s[j], s[j-1]);
            }
            s = ns;
        }
        int ans = s[0];
        for (int i = 1; i < s.length; i++) ans = Math.min(ans, s[i]);
        return ans;
    }
}
