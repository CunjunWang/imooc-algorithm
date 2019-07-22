//
// Created by 王存俊 on 2019-07-18.
//

#ifndef QUICK_SORT_QUICKSORTTHREEWAY_H
#define QUICK_SORT_QUICKSORTTHREEWAY_H

#include <iostream>
#include <algorithm>
#include "InsertionSort.h"

using namespace std;

// 递归的三路快速排序算法
template<typename T>
void __quickSortThreeWay(T arr[], int l, int r) {

    // 对于小规模数组, 使用插入排序进行优化
    if (r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }

    // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
    swap(arr[l], arr[rand() % (r - l + 1) + l]);

    T v = arr[l];

    int lt = l;     // arr[l+1...lt] < v
    int gt = r + 1; // arr[gt...r] > v
    int i = l + 1;    // arr[lt+1...i) == v
    while (i < gt) {
        if (arr[i] < v) {
            swap(arr[i], arr[lt + 1]);
            i++;
            lt++;
        } else if (arr[i] > v) {
            swap(arr[i], arr[gt - 1]);
            gt--;
        } else { // arr[i] == v
            i++;
        }
    }

    swap(arr[l], arr[lt]);

    __quickSortThreeWay(arr, l, lt - 1);
    __quickSortThreeWay(arr, gt, r);
}

template<typename T>
void quickSortThreeWay(T arr[], int n) {

    srand(time(NULL));
    __quickSortThreeWay(arr, 0, n - 1);
}

#endif //QUICK_SORT_QUICKSORTTHREEWAY_H
