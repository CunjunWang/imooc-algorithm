package com.cunjunwang.algorithm.advanceddatastructure.set;

import java.util.TreeSet;

/**
 * Created by CunjunWang on 2019-08-01.
 */
public class UniqueMorseCode {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                result.append(codes[word.charAt(i) - 'a']);
            }
            set.add(result.toString());
        }
        return set.size();
    }

}
