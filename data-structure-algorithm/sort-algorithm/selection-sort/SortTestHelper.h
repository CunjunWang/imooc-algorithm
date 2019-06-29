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

    template<typename T>
    void printArray(T arr[], int n) {
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        return;
    }

}

#endif //SELECTION_SORT_SORTTESTHELPER_H
