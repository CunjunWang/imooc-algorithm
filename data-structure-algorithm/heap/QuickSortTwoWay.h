//
// Created by 王存俊 on 2019-07-18.
//

#ifndef QUICK_SORT_QUICKSORTTWOWAY_H
#define QUICK_SORT_QUICKSORTTWOWAY_H

#include <iostream>
#include <algorithm>
#include "MergeSort.h"
#include "QuickSort.h"
#include "InsertionSort.h"
#include "SortTestHelper.h"

template<typename T>
int __partitionTwoWay(T arr[], int l, int r) {
    swap(arr[l], arr[rand() % (r - l + 1) + l]);
    T v = arr[l];

    // i: arr[l+1...i) <= v; arr(j...r] >= v
    int i = l + 1, j = r;
    while (true) {
        while (i <= r && arr[i] < v) {
            i++;
        }
        while (j >= l + 1 && arr[j] > v) {
            j--;
        }
        if (i > j) {
            break;
        }
        swap(arr[i], arr[j]);
        i++;
        j--;
    }

    swap(arr[l], arr[j]);
    return j;
}

template<typename T>
void __quickSortTwoWay(T arr[], int l, int r) {
    if (r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }
    int p = __partitionTwoWay(arr, l, r);
    __quickSortTwoWay(arr, l, p - 1);
    __quickSortTwoWay(arr, p + 1, r);
}

template<typename T>
void quickSortTwoWay(T arr[], int n) {
    srand(time(NULL));
    __quickSortTwoWay(arr, 0, n - 1);
}

#endif //QUICK_SORT_QUICKSORTTWOWAY_H
