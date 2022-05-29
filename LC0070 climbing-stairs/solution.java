class Solution {
    public int climbStairs(int n) {
        // s[i] = s[i - 1] + s[i - 2]
        // s[i]可以由s[i - 1]走一个1来, 和s[i - 2]走一个2来
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] s = new int[n + 1]; // i ~ n
        s[1] = 1;
        s[2] = 2;
        for (int i = 3; i < n + 1; i++) s[i] = s[i - 1] + s[i - 2];
        return s[n];
    }
}
