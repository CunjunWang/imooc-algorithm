package com.cunjunwang.algorithm.advancedgraph.dfs.single_source_path;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 求一点到另一点的路径
 * Created by CunjunWang on 2019-09-04.
 */
public class Path {

    private Graph G;

    private int source; // 源

    private int target; // 目标

    private int[] pre; // 每个顶点的前置顶点;

    /**
     * 在图中寻找源头source开始的路径
     *
     * @param G      图
     * @param source 源
     * @param target 目标
     */
    public Path(Graph G, int source, int target) {
        G.validateVertex(source);
        this.G = G;
        this.source = source;
        this.target = target;
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(source, source);
        for (int i : pre) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 对Graph进行深度优先遍历, 寻找单源路径
     * 递归写法
     *
     * @param v      顶点
     * @param parent 上一个顶点
     * @return 从当前顶点v是否能到达target
     */
    private boolean dfs(int v, int parent) {
        pre[v] = parent;
        if (v == target)
            return true;
        for (int w : G.adj(v))
            if (pre[w] == -1 && dfs(w, v))
                return true;

        return false;
    }

    /**
     * 从source出发是否有到达target的路径
     *
     * @return 是否有路径
     */
    public boolean isConnected() {
        return pre[target] != -1;
    }

    /**
     * 从source出发到target的路径
     *
     * @return 路径
     */
    public Iterable<Integer> path() {
        ArrayList<Integer> res = new ArrayList<>();
        if (isConnected()) {
            int cur = target;
            while (cur != source) {
                res.add(cur);
                cur = pre[cur];
            }
            res.add(source);
            Collections.reverse(res);
            return res;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g1.txt";
        Graph G = new Graph(filename);
        int source = 0;
        int target = 6;
        Path path = new Path(G, source, target);
        System.out.println(source + " -> " + target + " : " + path.path());
    }

}
