package com.cunjunwang.algorithm.advanceddatastructure.trie;

import com.cunjunwang.algorithm.advanceddatastructure.set.BSTSet;
import com.cunjunwang.algorithm.advanceddatastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-09-02.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        String fileName = "./src/main/java/com/cunjunwang/algorithm/advanceddatastructure/map/pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }

            for (String word : words) {
                set.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // -- trie
            startTime = System.nanoTime();

            Trie  trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }

}
