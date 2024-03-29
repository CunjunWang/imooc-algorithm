package com.cunjunwang.algorithm.advanceddatastructure.map;

import com.cunjunwang.algorithm.advanceddatastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-08-01.
 */
public class TestMap {

    private static double testMap(Map<String, Integer> map, String fileName) {
        double startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.get(word) != null) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        double endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fileName = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, fileName);
        System.out.println("BST Map: " + time1 + " s.");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, fileName);
        System.out.println("Linked list Map: " + time2 + " s.");
    }

}
