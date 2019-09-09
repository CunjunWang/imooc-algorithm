package com.cunjunwang.algorithm.advancedgraph.search.Leetcode773_SlidingPuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CunjunWang on 2019-09-08.
 */
public class SlidingPuzzle {

    private int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {
        String endState = "123450";
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        String initialState = boardToString(board);
        if (initialState.equals(endState))
            return 0;
        queue.add(initialState);
        visited.put(initialState, 0);
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            ArrayList<String> nexts = getNexts(cur);

            for (String next : nexts) {
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);

                    if (next.equals(endState)) {
                        return visited.get(next);
                    }
                }
            }
        }

        return -1;
    }

    private ArrayList<String> getNexts(String s) {
        ArrayList<String> res = new ArrayList<>();
        int[][] cur = stringToBoard(s);
        int zero;
        for (zero = 0; zero < 6; zero++) {
            if (cur[zero / 3][zero % 3] == 0)
                break;
        }
        int zx = zero / 3, zy = zero % 3;

        for (int d = 0; d < 4; d++) {
            int nextx = zx + dirs[d][0];
            int nexty = zy + dirs[d][1];
            if (inArea(nextx, nexty)) {
                swap(cur, zx, zy, nextx, nexty);
                String nextBoard = boardToString(cur);
                res.add(nextBoard);
                // 回溯，要恢复盘面
                swap(cur, zx, zy, nextx, nexty);
            }
        }
        return res;
    }

    private String boardToString(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    private int[][] stringToBoard(String s) {
        int[][] board = new int[2][3];
        for (int i = 0; i < 6; i++) {
            // 1d -> 2d
            board[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return board;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int val1 = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = val1;
    }
}
