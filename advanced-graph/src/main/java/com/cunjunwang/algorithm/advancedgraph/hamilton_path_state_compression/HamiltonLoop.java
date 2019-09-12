package com.cunjunwang.algorithm.advancedgraph.hamilton_path_state_compression;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * dfs暴力求解图的汉密尔顿回路
 * Created by CunjunWang on 2019-09-11.
 */
public class HamiltonLoop {

    private Graph G;

    private boolean[] visited;

    private int[] pre; // 记录父亲节点

    private int end; // 起始点前一个顶点

    public HamiltonLoop(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;

        // 只需要从一个点开始
        dfs(0, 0, G.V());
    }

    /**
     * 对Graph进行深度优先遍历求汉密尔顿回路
     * O(V + E)
     *
     * @param v
     */
    private boolean dfs(int v, int parent, int left) {
        visited[v] = true;
        pre[v] = parent;
        left--;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v, left)) {
                    return true;
                }
            } else if (w == 0 && left == 0) {
                end = v;
                return true;
            }
        }
        // 回溯 backtrack searching
        visited[v] = false;
        return false;
    }

    public ArrayList<Integer> result() {
        ArrayList<Integer> res = new ArrayList<>();
        if (end == -1)
            return res;
        int cur = end;
        while(cur != 0) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g5.txt";
        Graph G = new Graph(filename);
        HamiltonLoop hamiltonLoop = new HamiltonLoop(G);
        System.out.println("Result: " + hamiltonLoop.result());
    }

}
