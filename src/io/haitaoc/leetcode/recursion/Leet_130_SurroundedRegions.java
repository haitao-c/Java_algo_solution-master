package io.haitaoc.leetcode.recursion;

public class Leet_130_SurroundedRegions {
    boolean[][] visited;
    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0)
            return;
        int n = board[0].length;

        visited = new boolean[m][n];

        // 找到边界上的O进行dfs, 将与其连通的O全部标记成1, 最后遍历数组, 把为O的部分标记为x,为1的部分标记为O就好了
        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O')
                dfs(board, 0, col);     // 最上边一行
            if (board[m - 1][col] == 'O')
                dfs(board, m - 1, col);    // 最下边一行
        }

        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O')
                dfs(board, row, 0);     // 最上边一行
            if (board[row][n - 1] == 'O')
                dfs(board, row, n - 1);    // 最下边一行
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='1')
                    board[i][j] = 'O';
            }

        }


    }

    private void dfs(char[][] board, int row, int col) {
        if (inArea(board, row, col))
            if (!visited[row][col]) {
                visited[row][col] = true;
                if(board[row][col]=='X')
                    return;
                if (board[row][col] == 'O')
                    board[row][col] = '1';
                for (int i = 0; i < 4; i++) {
                    int newX = row + directions[i][0];
                    int newY = col + directions[i][1];
                    dfs(board, newX, newY);
                }
            } else
                return;

    }

    private boolean inArea(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new Leet_130_SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
