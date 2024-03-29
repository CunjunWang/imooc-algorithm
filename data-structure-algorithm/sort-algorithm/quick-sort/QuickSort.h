//
// Created by 王存俊 on 2019-07-18.
//

#ifndef QUICK_SORT_QUICKSORT_H
#define QUICK_SORT_QUICKSORT_H

#include <iostream>
#include <algorithm>
#include "MergeSort.h"
#include "InsertionSort.h"
#include "SortTestHelper.h"

// 对arr[l...r]进行partition
// 返回索引值: 使得arr[l...p-1] < arr[p], arr[p+1...r] > arr[p]
template<typename T>
int __partition(T arr[], int l, int r) {

    swap(arr[l], arr[rand() % (r - l + 1) + l]);

    T v = arr[l];

    // arr[l+1...j] < v, arr[j+1...i] > v
    int j = l;
    for (int i = l + 1; i <= r; i++) {
        if (arr[i] < v) {
            // swap(arr[++j], arr[i]);
            swap(arr[j + 1], arr[i]);
            j++;
        }
    }
    swap(arr[l], arr[j]);
    return j;
}

// 对arr[l...r]进行quick sort
template<typename T>
void __quickSort(T arr[], int l, int r) {
//    if (l >= r) {
//        return;
//    }
    // 优化: 高级排序算法到底层可以用插入排序加快速度
    if (r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }

    int p = __partition(arr, l, r);
    __quickSort(arr, l, p - 1);
    __quickSort(arr, p + 1, r);
}

template<typename T>
void quickSort(T arr[], int n) {
    // 优化: 随机选择一个pivot
    srand(time(NULL));
    __quickSort(arr, 0, n - 1);
}

#endif //QUICK_SORT_QUICKSORT_H
