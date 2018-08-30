package io.haitaoc.leetcode.recursion;

public class Leet_200_NumberOfIslands {

    // 向上移动, x位置-1, y位置不动
    // 向右移动, x位置不动, y位置+1
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};      // 本题不要求顺序
    int m, n;
    boolean[][] visited;

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从grid[x][y]的位置开始, 进行floodfill
    private void dfs(char[][] grid, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                dfs(grid, newx, newy);
            }
        }
        return;
    }

}
