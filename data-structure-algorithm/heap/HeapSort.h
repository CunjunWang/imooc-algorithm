//
// Created by 王存俊 on 2019-07-22.
//

#ifndef HEAP_HEAPSORT_H
#define HEAP_HEAPSORT_H

#include <iostream>
#include <algorithm>

template<typename T>
void heapSort1(T arr[], int n) {
    MaxHeap<T> maxHeap = MaxHeap<T>(n);

    for (int i = 0; i < n; i++) {
        maxHeap.insert(arr[i]);
    }

    for (int i = n - 1; i >= 0; i--) {
        arr[i] = maxHeap.extractMax();
    }
}

// heapify constructor
template<typename T>
void heapSort2(T arr[], int n) {
    MaxHeap<T> maxHeap = MaxHeap<T>(arr, n);

    for (int i = n - 1; i >= 0; i--) {
        arr[i] = maxHeap.extractMax();
    }
}

#endif //HEAP_HEAPSORT_H
