package com.cunjunwang.algorithm.advancedgraph.search.Leetcode1091_ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CunjunWang on 2019-09-08.
 */
public class ShortestPathInBinaryMatrix {

    private int R, C;

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int[][] dis = new int[R][C];

        if (grid[0][0] == 1)
            return -1;
        if (R == 1 && C == 1)
            return 1;

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dis[0][0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            // 1d -> 2d
            int curx = cur / C, cury = cur % C;
            for (int d = 0; d < 8; d++) {
                int nextx = curx + dirs[d][0];
                int nexty = cury + dirs[d][1];
                if (inArea(nextx, nexty) && !visited[nextx][nexty] && grid[nextx][nexty] == 0) {
                    // 2d -> 1d
                    queue.add(nextx * C + nexty);
                    visited[nextx][nexty] = true;
                    dis[nextx][nexty] = dis[curx][cury] + 1;

                    if (nextx == R - 1 && nexty == C - 1) {
                        return dis[nextx][nexty];
                    }
                }
            }
        }

        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
