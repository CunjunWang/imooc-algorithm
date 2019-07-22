#include <iostream>
#include <algorithm>
#include "Heap.h"
#include "MergeSort.h"
#include "InsertionSort.h"
#include "QuickSort.h"
#include "QuickSortTwoWay.h"
#include "QuickSortThreeWay.h"

using namespace std;

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


int main() {
    int n = 1000000;

    // test 1: general test
    cout << "Test for Random Array, size = " << n << ", random range [0, " << n << "]" << endl;
    int *arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int *arr2 = SortTestHelper::copyIntArray(arr1, n);
    int *arr3 = SortTestHelper::copyIntArray(arr1, n);
    int *arr4 = SortTestHelper::copyIntArray(arr1, n);
    int *arr5 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick sort three ways", quickSortThreeWay, arr3, n);
    SortTestHelper::testSort("Heap sort 1", heapSort1, arr4, n);
    SortTestHelper::testSort("Heap sort 2", heapSort2, arr5, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;

    cout << endl;
}