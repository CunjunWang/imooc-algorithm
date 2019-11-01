package com.cunjunwang.algorithm.advancedgraph.hamilton_path;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * dfs暴力求解图的汉密尔顿回路, visited经过状态压缩
 * Created by CunjunWang on 2019-09-11.
 */
public class HamiltonLoop {

    private Graph G;

    private int[] pre; // 记录父亲节点

    private int end; // 起始点前一个顶点

    public HamiltonLoop(Graph G) {
        this.G = G;
        pre = new int[G.V()];
        end = -1;

        int visited = 0;
        // 只需要从一个点开始
        dfs(visited, 0, 0, G.V());
    }

    /**
     * 对Graph进行深度优先遍历求汉密尔顿回路
     * O(V + E)
     *
     * @param v
     */
    private boolean dfs(int visited, int v, int parent, int left) {
        visited += (1 << v);
        pre[v] = parent;
        left--;
        if (left == 0 && G.hasEdge(v, 0)) {
            end = v;
            return true;
        }

        for (int w : G.adj(v)) {
            // & 的优先级很低, 比 == 低
            if ((visited & (1 << w)) == 0) {
                if (dfs(visited, w, v, left)) {
                    return true;
                }
            }
        }
        // 回溯 backtrack searching
        left++; // 其实可以不写这句话
        visited -= (1 << v);
        return false;
    }

    public ArrayList<Integer> result() {
        ArrayList<Integer> res = new ArrayList<>();
        if (end == -1)
            return res;
        int cur = end;
        while (cur != 0) {
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
