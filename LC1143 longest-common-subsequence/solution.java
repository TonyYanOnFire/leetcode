// 64.32%
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 阶段: 两个指针, 指向text1, text2
        // 状态s[i][j] text1[:i] text2[:j]的公共子序列
        // 决策/转移方程 s[i][j] = text1[i] == text2[j] ? 1 + s[i - 1][j - 1] : max(s[i - 1][j], s[i][j -1])
        // 技巧: 这是top-down的方程x ~ x-1. 状态空间多来一个值, 表示边界
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        text1 = " " + text1;
        text2 = " " + text2;

        int[][] s = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    s[i][j] = s[i - 1][j - 1] + 1;
                } else {
                    s[i][j] = Math.max(s[i - 1][j], s[i][j -1]);
                }
            }
        }
        return s[m - 1][n - 1];
    }
}
