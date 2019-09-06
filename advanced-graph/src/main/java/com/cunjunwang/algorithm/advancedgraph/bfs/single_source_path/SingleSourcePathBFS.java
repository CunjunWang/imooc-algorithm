package com.cunjunwang.algorithm.advancedgraph.bfs.single_source_path;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于广度优先遍历BFS解决单源路径问题
 * Created by CunjunWang on 2019-09-05.
 */
public class SingleSourcePathBFS {

    private Graph G;

    private int source;

    private int[] pre; // 每个点在遍历过程中的前一个节点

    public SingleSourcePathBFS(Graph G, int source) {
        this.G = G;
        this.source = source;
        this.pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        bfs(source);
    }

    /**
     * 从顶点v开始执行广度优先搜索
     * 迭代写法
     * O(V + E)
     *
     * @param v 顶点
     */
    private void bfs(int v) {
        // bfs的队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        pre[v] = v;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (int w : G.adj(cur)) {
                if (pre[w] == -1) {
                    queue.add(w);
                    pre[w] = cur; // 记录该节点的前一个节点, 倒推出路径
                }
            }
        }
    }

    /**
     * 从source出发是否能到达target
     *
     * @param target 目标
     * @return 是否相连
     */
    public boolean isConnectedTo(int target) {
        G.validateVertex(target);
        return pre[target] != -1;
    }

    /**
     * 找到从source到target的一条路径
     *
     * @param target 目标
     * @return source到target的路径
     */
    public Iterable<Integer> path(int target) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnectedTo(target))
            return res;
        int cur = target;
        while (cur != source) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(source);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt";
        Graph G = new Graph(filename);
        int source = 0;
        int target = 6;
        SingleSourcePathBFS singleSourcePathBFS = new SingleSourcePathBFS(G, source);
        System.out.println("0 -> 6: " + singleSourcePathBFS.path(target));
    }

}
