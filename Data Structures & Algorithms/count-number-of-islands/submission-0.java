public class Solution {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        // base cases: out of bounds, already visited, or water
        if (i < 0 || j < 0 || i >= n || j >= m 
            || grid[i][j] != '1' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // explore neighbors (up, down, left, right)
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}