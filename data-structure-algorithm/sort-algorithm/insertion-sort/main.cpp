#include <iostream>
#include "SortTestHelper.h"
#include "SelectionSort.h"

// insertion sort
// O(n)

// 对于近乎有序的数组, 插入排序的性能比之后的O(nlg(n))的算法性能还要好

using namespace std;

// 原始版本
template<typename T>
void insertionSortOrigin(T arr[], int n) {
    for (int i = 1; i < n; i++) {
        // 寻找元素arr[i]合适的插入位置
        for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
            swap(arr[j], arr[j - 1]);
        }
    }
}

// 改进版本
// 不直接交换, 先保存起来做比较大小
template<typename T>
void insertionSortOptimized(T arr[], int n) {
    for (int i = 1; i < n; i++) {
        T e = arr[i];
        int j; // j保存元素e应该插入的位置
        for (j = i; j > 0 && (arr[j - 1] > e); j--) {
            arr[j] = arr[j - 1];
        }
        arr[j] = e;
    }
}

int main() {
    int n = 100000;
    int *arr = SortTestHelper::generateNearlyOrderedArray(n, 0);
    int *arr2 = SortTestHelper::copyIntArray(arr, n);
    int *arr3 = SortTestHelper::copyIntArray(arr, n);

    SortTestHelper::testSort("Insertion Sort optimized", insertionSortOptimized, arr, n);
    SortTestHelper::testSort("Insertion Sort origin", insertionSortOrigin, arr2, n);
    SortTestHelper::testSort("Selection Sort", selectionSort, arr3, n);

    delete[] arr;
    delete[] arr2;
    delete[] arr3;
    return 0;
}