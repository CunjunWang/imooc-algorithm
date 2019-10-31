package com.cunjunwang.algorithm.advancedgraph.minimal_spanning_tree;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CunjunWang on 2019-10-30.
 */
public class ConnectedComponent {

    private WeightedGraph G;

    private int[] visited;

    private int connectedComponentCount;

    public ConnectedComponent(WeightedGraph G) {
        this.G = G;
        visited = new int[G.V()];
        connectedComponentCount = 0;
        for (int i = 0; i < visited.length; i++)
            visited[i] = -1;
        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                bfs(v, connectedComponentCount);
                connectedComponentCount++;
            }
    }

    /**
     * 对Graph进行广度优先遍历, 求解联通分量
     * O(V + E)
     *
     * @param v           顶点
     * @param componentId 联通分量Id
     */
    private void bfs(int v, int componentId) {
        Queue<Integer> todo = new LinkedList<>();
        todo.add(v);
        visited[v] = componentId;
        while (!todo.isEmpty()) {
            Integer cur = todo.remove();
            for (int w : G.adj(cur)) {
                if (visited[w] == -1) {
                    todo.add(w);
                    visited[w] = componentId;
                }
            }
        }
    }

    /**
     * 获得联通分量个数
     *
     * @return 联通分量个数
     */
    public int getConnectedComponentCount() {
        for (int e : visited) {
            System.out.print(e + " ");
        }
        System.out.println();
        return connectedComponentCount;
    }

    /**
     * 判断两节点是否相连
     *
     * @param v 节点1
     * @param w 节点2
     * @return 是否相连
     */
    public boolean isConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    /**
     * 获取联通分量, 和每个联通分量有哪些元素
     *
     * @return 联通分量
     */
    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] res = new ArrayList[connectedComponentCount];
        for (int i = 0; i < connectedComponentCount; i++) {
            res[i] = new ArrayList<>();
        }
        for (int v = 0; v < G.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }

}
