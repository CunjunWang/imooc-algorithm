package com.cunjunwang.algorithm.advancedgraph.dfs.single_source_path;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 解决单源路径问题
 * Created by CunjunWang on 2019-09-04.
 */
public class SingleSourcePathDFS {

    private Graph G;

    private int source; // 源

    private int[] pre; // 每个顶点的前置顶点;

    /**
     * 在图中寻找源头source开始的路径
     *
     * @param G      图
     * @param source 源
     */
    public SingleSourcePathDFS(Graph G, int source) {
        G.validateVertex(source);
        this.G = G;
        this.source = source;
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(source, source);
    }

    /**
     * 对Graph进行深度优先遍历, 寻找单源路径
     * 递归写法
     *
     * @param v      顶点
     * @param parent 上一个顶点
     */
    private void dfs(int v, int parent) {
        pre[v] = parent;
        for (int w : G.adj(v))
            if (pre[w] == -1)
                dfs(w, v);
    }

    /**
     * 从source出发是否有到达target的路径
     *
     * @param target 目标
     * @return 是否有路径
     */
    public boolean isConnectedTo(int target) {
        G.validateVertex(target);
        return pre[target] != -1;
    }

    /**
     * 从source出发到target的路径
     *
     * @param target 目标
     * @return 路径
     */
    public Iterable<Integer> path(int target) {
        ArrayList<Integer> res = new ArrayList<>();
        if (isConnectedTo(target)) {
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
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt";
        Graph G = new Graph(filename);
        int source = 0;
        SingleSourcePathDFS singleSourcePathDFS = new SingleSourcePathDFS(G, source);
        int target = 6;
        System.out.println(source + " -> " + target + " : " + singleSourcePathDFS.path(target));
    }

}
