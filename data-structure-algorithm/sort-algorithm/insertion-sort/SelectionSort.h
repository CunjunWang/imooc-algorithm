//
// Created by 王存俊 on 2019-06-29.
//

#ifndef IMOOC_ALGORITHM_SELECTIONSORT_H
#define IMOOC_ALGORITHM_SELECTIONSORT_H

using namespace std;

template<typename T>
void selectionSort(T arr[], int n) {
    for (int i = 0; i < n; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }
}

#endif //IMOOC_ALGORITHM_SELECTIONSORT_H
