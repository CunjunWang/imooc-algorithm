//
// Created by 王存俊 on 2019-06-29.
//

#ifndef SELECTION_SORT_SORTTESTHELPER_H
#define SELECTION_SORT_SORTTESTHELPER_H

#include <iostream>
#include <cassert>

using namespace std;

namespace SortTestHelper {

    // 生成有n个元素的随机数组, 每个元素的随机范围为[rangeL, rangeR)
    int *generateRandomArray(int n, int rangeL, int rangeR) {
        assert(rangeL <= rangeR);
        int *arr = new int[n];
        // set random seed
        srand(time(NULL));
        for (int i = 0; i < n; i++) {
            arr[i] = rand() % (rangeR - rangeL + 1) + rangeL;
        }
        return arr;

    }

    // 生成近乎有序的数组
    int *generateNearlyOrderedArray(int n, int swapTimes) {
        int *arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        srand(time(NULL));
        for (int i = 0; i < swapTimes; i++) {
            int posx = rand() % n;
            int posy = rand() % n;
            swap(arr[posx], arr[posy]);
        }
        return arr;
    }

    template<typename T>
    void printArray(T arr[], int n) {
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

    template<typename T>
    bool isSorted(T arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 第二个参数是函数指针
    // void是函数返回值, (*xxx)表示函数指针, 再后面是函数入参
    template<typename T>
    void testSort(string sortName, void(*sort)(T[], int n), T arr[], int n) {
        clock_t startTime = clock();
        sort(arr, n);
        clock_t endTime = clock();
        assert(isSorted(arr, n));
        cout << sortName << " : " << double(endTime - startTime) / CLOCKS_PER_SEC << " s" << endl;
        return;
    }

    int *copyIntArray(int a[], int n) {
        int *arr = new int[n];
        // 原数组头指针, 原数组尾指针(使用+进行指针移动, 目标数组头指针)
        copy(a, a + n, arr);
        return arr;
    }

}

#endif //SELECTION_SORT_SORTTESTHELPER_H
