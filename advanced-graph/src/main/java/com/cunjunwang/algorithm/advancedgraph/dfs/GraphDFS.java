package com.cunjunwang.algorithm.advancedgraph.dfs;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by CunjunWang on 2019-09-03.
 */
public class GraphDFS {

    private Graph G;

    private boolean[] visited;

    // 先序dfs之后的结果
    private ArrayList<Integer> pre = new ArrayList<>();
    // 后序dfs之后的结果
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * 对Graph进行深度优先遍历
     * 递归写法
     * <p>
     * O(V + E)
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w);
        post.add(v);
    }

    private void dfsIterative(int v) {
        Stack<Integer> todo = new Stack<>();
        todo.push(v);
        visited[v] = true;
        while (!todo.empty()) {
            Integer cur = todo.pop();
            pre.add(cur);
            for (int w : G.adj(cur)) {
                if (!visited[w]) {
                    todo.push(w);
                    visited[w] = true;
                }
            }
            post.add(cur);
        }
    }

    /**
     * 获得先序遍历结果
     *
     * @return pre 先序遍历结果
     */
    public Iterable<Integer> getPre() {
        return pre;
    }

    /**
     * 获得后序遍历结果
     *
     * @return post 后序遍历结果
     */
    public Iterable<Integer> getPost() {
        return post;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/test_graph/ug.txt";
        Graph G = new Graph(filename, true);
        GraphDFS graphDFS = new GraphDFS(G);
        System.out.println("Pre: " + graphDFS.getPre());
        System.out.println("Post: " + graphDFS.getPost());
    }

}
