package com.cunjunwang.algorithm.advanceddatastructure.set;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-07-31.
 */
public class TestSet {

    private static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(fileName, words1);
        System.out.println("Total words: " + words1.size());
        for (String word : words1) {
            set.add(word);
        }
        System.out.println("Total different words: " + set.getSize());

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fileName = "pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, fileName);
        System.out.println("BST set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, fileName);
        System.out.println("Linked list set: " + time2 + " s");
    }

}
