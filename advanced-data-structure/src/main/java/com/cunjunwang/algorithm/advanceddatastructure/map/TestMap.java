package com.cunjunwang.algorithm.advanceddatastructure.map;

import com.cunjunwang.algorithm.advanceddatastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-08-01.
 */
public class TestMap {

    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words1) {
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

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words2) {
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
    }

}
