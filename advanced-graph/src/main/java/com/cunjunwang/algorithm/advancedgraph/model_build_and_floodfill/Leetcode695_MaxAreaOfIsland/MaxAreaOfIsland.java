package com.cunjunwang.algorithm.advancedgraph.model_build_and_floodfill.Leetcode695_MaxAreaOfIsland;

/**
 * Created by CunjunWang on 2019-09-06.
 */

public class MaxAreaOfIsland {

    private int m, n;
    private boolean[][] visited;
    private int[][] grid;
    private int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;

        this.grid = grid;
        this.visited = new boolean[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int result = dfs(i, j);
                    max = Math.max(max, result);
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j) {
        visited[i][j] = true;
        int ret = 1;
        for (int k = 0; k < 4; k++) {
            int[] d = direction[k];
            int newX = i + d[0];
            int newY = j + d[1];
            if (inArea(newX, newY) && grid[newX][newY] == 1 &&
                    !visited[newX][newY]) {
                visited[newX][newY] = true;
                ret += dfs(newX, newY);
            }
        }
        return ret;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}

// My solution
//public class MaxAreaOfIsland {
//
//    private int m, n;
//    private boolean[][] visited;
//    private int[][] grid;
//    private int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//
//    public int maxAreaOfIsland(int[][] grid) {
//        m = grid.length;
//        if (m == 0) return 0;
//        n = grid[0].length;
//        if (n == 0) return 0;
//
//        this.grid = grid;
//        this.visited = new boolean[m][n];
//
//        int max = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!visited[i][j] && grid[i][j] == 1) {
//                    int result = dfs(i, j);
//                    max = Math.max(max, result);
//                }
//            }
//        }
//        return max;
//    }
//
//    private int dfs(int i, int j) {
//        visited[i][j] = true;
//        int ret = 1;
//        for (int k = 0; k < 4; k++) {
//            int[] d = direction[k];
//            int newX = i + d[0];
//            int newY = j + d[1];
//            if (inArea(newX, newY) && grid[newX][newY] == 1 &&
//                    !visited[newX][newY]) {
//                visited[newX][newY] = true;
//                ret += dfs(newX, newY);
//            }
//        }
//        return ret;
//    }
//
//    private boolean inArea(int x, int y) {
//        return x >= 0 && x < m && y >= 0 && y < n;
//    }
//
//}
