class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 考虑矩阵f表示每个格子到终点end的路径数量, 那么f[x][y] = f[x + 1][y] + f[x][y + 1]
        // 递推+记忆化

        // 还可以考虑f为每个格子到start的路径数量, 那么f[x][y] = f[x - 1][y] + f[x][y - 1]
        // 初始时f[0][0] = 1, 返回calc(m-1, n-1)
        
        this.obstacleGrid = obstacleGrid;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        // 终点被堵住, 直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        s = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = obstacleGrid[i][j] == 1 ? 0 : -1;
            }
        }
        s[m - 1][n - 1] = 1;
        return calc(0, 0);
    }

    int[][] s;
    int[][] obstacleGrid;
    int m;
    int n;

    int calc(int x, int y) {
        if (x >= m || y >= n) return 0;
        if (s[x][y] == -1) s[x][y] = calc(x + 1, y) + calc(x, y + 1);
        return s[x][y];
    }
}
