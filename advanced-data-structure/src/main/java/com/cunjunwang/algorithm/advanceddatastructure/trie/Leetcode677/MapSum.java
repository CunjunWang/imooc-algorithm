package com.cunjunwang.algorithm.advanceddatastructure.trie.Leetcode677;

import java.util.TreeMap;

/**
 * Created by CunjunWang on 2019-09-02.
 */
public class MapSum {

    private class Node {

        public int val; // 该节点的权重值
        public TreeMap<Character, Node> next; // 后续节点集合

        public Node(int value) {
            this.val = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.val;

        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }

        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */