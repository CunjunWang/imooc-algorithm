package com.cunjunwang.algorithm.advancedgraph.dfs.connected_component;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 具体求解联通分量
 * Created by CunjunWang on 2019-09-04.
 */
public class SolveConnectedComponent {

    private Graph G;

    private int[] visited;

    private int connectedComponentCount;

    public SolveConnectedComponent(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        connectedComponentCount = 0;
        for (int i = 0; i < visited.length; i++)
            visited[i] = -1;
        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                dfs(v, connectedComponentCount);
                connectedComponentCount++;
            }
    }

    /**
     * 对Graph进行深度优先遍历
     * 递归写法
     * <p>
     * O(V + E)
     *
     * @param v           顶点
     * @param componentId 联通分量Id
     */
    private void dfs(int v, int componentId) {
        visited[v] = componentId;
        for (int w : G.adj(v))
            if (visited[w] == -1)
                dfs(w, componentId);
    }

    /**
     * 对Graph进行深度优先遍历
     * 迭代写法
     *
     * @param v           顶点
     * @param componentId 联通分量Id
     */
    private void dfsIterative(int v, int componentId) {
        Stack<Integer> todo = new Stack<>();
        todo.push(v);
        visited[v] = componentId;
        while (!todo.empty()) {
            Integer cur = todo.pop();
            for (int w : G.adj(cur)) {
                if (visited[w] == -1) {
                    todo.push(w);
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

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g1.txt";
        Graph G = new Graph(filename);
        SolveConnectedComponent cc = new SolveConnectedComponent(G);
        System.out.println(cc.getConnectedComponentCount());
        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(0, 5));
        ArrayList<Integer>[] comp = cc.components();
        for (int i = 0; i < comp.length; i++) {
            System.out.print(i + " : ");
            System.out.println(comp[i].toString());
        }
    }

}
