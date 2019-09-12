package com.cunjunwang.algorithm.advancedgraph.hamilton_path_state_compression.Leetcode980_UniquePathsIII;

/**
 * Created by CunjunWang on 2019-09-11.
 */
public class UniquePathsIII {

    private int[][] grid;

    private int R, C;

    private boolean[][] visited;

    private int start, end;

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R][C];
        int left = R * C;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    start = i * C + j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    end = i * C + j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    left--;
                }
            }
        }
        if (left == 0)
            return 0;

        return dfs(start, left);
    }

    private int dfs(int v, int left) {
        int x = v / C;
        int y = v % C;
        visited[x][y] = true;
        left--;

        if (left == 0 && v == end) {
            // 回溯, 因为要找到所有的路径
            visited[x][y] = false;
            return 1;
        }

        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nextx = x + dirs[d][0];
            int nexty = y + dirs[d][1];
            if (inArea(nextx, nexty) && grid[nextx][nexty] == 0 && !visited[nextx][nexty]) {
                res += dfs(nextx * C + nexty, left);
            }
        }

        visited[x][y] = false;
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >=0 && y < C;
    }
}
