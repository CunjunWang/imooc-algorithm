package com.cunjunwang.algorithm.advanceddatastructure.trie;

import java.util.TreeMap;

/**
 * Created by CunjunWang on 2019-09-02.
 */
public class Trie {

    private class Node {
        public boolean isWord; // 当前节点是否是一个单词的结尾
        public TreeMap<Character, Node> next; // 后续节点集合

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }


    private Node root; // Trie的根节点
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie存储了多少个单词
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 向trie中添加新的单词
     *
     * @param word 待添加的单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 把当前节点标记为单词的结尾, 且这个节点之前不能是一个单词
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词是否在trie中
     *
     * @param word 待查询的单词
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 在trie中查询是否有单词以指定前缀为前缀
     *
     * @param prefix 指定前缀
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
