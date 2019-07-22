#include <iostream>
#include <algorithm>
#include "Heap.h"
#include "HeapSort.h"
#include "MergeSort.h"
#include "InsertionSort.h"
#include "QuickSort.h"
#include "QuickSortTwoWay.h"
#include "QuickSortThreeWay.h"

using namespace std;

template<typename T>
void __shiftDown(T arr[], int n, int k) {
    while (2 * k + 1 < n) {
        int j = 2 * k + 1; // 此次迭代中 arr[k]和arr[j]交换位置
        if (j + 1 < n && arr[j + 1] > arr[j]) {
            j += 1;
        }
        if (arr[k] >= arr[j]) {
            break;
        }
        swap(arr[k], arr[j]);
        k = j;
    }
}

template<typename T>
void heapSort(T arr[], int n) {

    // heapify
    for (int i = (n - 1) / 2; i >= 0; i--) {
        __shiftDown(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
        swap(arr[0], arr[i]);
        __shiftDown(arr, i, 0);
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
    int *arr6 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick sort three ways", quickSortThreeWay, arr3, n);
    SortTestHelper::testSort("Heap sort 1", heapSort1, arr4, n);
    SortTestHelper::testSort("Heap sort 2", heapSort2, arr5, n);
    SortTestHelper::testSort("Heap sort in place", heapSort, arr6, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;
    delete[] arr6;

    cout << endl;
}