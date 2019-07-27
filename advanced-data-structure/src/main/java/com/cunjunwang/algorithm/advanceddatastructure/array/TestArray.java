package com.cunjunwang.algorithm.advanceddatastructure.array;

/**
 * Created by CunjunWang on 2019-07-25.
 */
public class TestArray {

    public static void main(String[] args) {
//
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//
//        int[] scores = new int[]{100, 99, 66};
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]);
//        }
//
//        scores[0] = 98;
//
//        for (int score : scores) {
//            System.out.println(score);
//        }
//        Array<Integer> arr = new Array<>(20);
//        for (int i = 0; i < 10; i++) {
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//
//        arr.add(1, 100);
//        System.out.println(arr);
//
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        int i = arr.get(0);
//        System.out.println(i);
//
//        arr.set(5, 10);
//        System.out.println(arr);

        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));
        System.out.println(arr);

    }
}
