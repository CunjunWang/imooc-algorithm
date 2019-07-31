package com.cunjunwang.algorithm.advanceddatastructure.set;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-07-31.
 */
public class TestSet {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());

        LinkedListSet<String> set1 = new LinkedListSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());

        System.out.println();

        System.out.println("A tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", words2);
        System.out.println("Total words: " + words2.size());

        LinkedListSet<String> set2 = new LinkedListSet<>();
        for (String word : words2) {
            set2.add(word);
        }
        System.out.println("Total different words: " + set2.getSize());
    }

}
