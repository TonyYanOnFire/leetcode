class Solution {
    public void solve(char[][] board) {
        // 想复杂了. 就是从边上的O出发进行标记. 标记过的O改成X
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++){
            // 首尾行遍历全部列, 否则只考虑前后
            if (i == 0 || i == m - 1) {
                for (int j = 0; j < n; j ++) dfs(i, j);
            } else {
                dfs(i, 0);
                dfs(i, n - 1);
            }
        }

        // 染色完成, 现在被包围的O还是O, 未被包围的O是A, 因此把A改为O, 把O改为X
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    char[][] board;
    int m, n;
    int[] dx = {-1, 1,  0, 0};
    int[] dy = { 0, 0, -1, 1};


    void dfs(int x, int y) {
        // 从边上的O出发, 将相邻的O染色为A. 因此边界条件包括不等于O, 注意java下char字面量用单引号
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
        board[x][y] = 'A';
        for (int i = 0; i < 4; i++) dfs(x + dx[i], y + dy[i]);
    }
}
