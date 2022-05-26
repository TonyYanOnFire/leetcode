class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 对于饼干s[i], 分给max(g[j]) g[j] <= s[i]. 消耗了同样的饼干, 解决了更多的空缺
        // 即对于每个胃口, 分给大于这个胃口的饼干里最小的那块
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int ans = 0;
        for (int child : g) {
            while (j < s.length && s[j] < child) j++;
            if (j < s.length) {
                ans++;
                j++;
            } else {
                break;
            }
        }

        return ans;
    }
}
