#include <iostream>
#include <algorithm>
#include "InsertionSort.h"
#include "SortTestHelper.h"

using namespace std;

// 自底向上merge sort
template<typename T>
void mergeSortBU(T arr[], int n) {
    for (int size = 1; size <= n; size += size) {
        for (int i = 0; i + size < n; i += size + size) {
            __merge(arr, i, i + size - 1, min(i + size + size - 1, n - 1));
        }
    }
}

// 对arr[l...mid]和arr[mid+1...r]进行归并
template<typename T>
void __merge(T arr[], int l, int mid, int r) {
    T aux[r - l + 1];
    for (int i = l; i <= r; i++) {
        aux[i - l] = arr[i];
    }

    int i = l, j = mid + 1;
    for (int k = l; k <= r; k++) {
        if (i > mid) {
            arr[k] = aux[j - l];
            j++;
        } else if (j > r) {
            arr[k] = aux[i - l];
            i++;
        } else if (aux[i - l] < aux[j - l]) {
            arr[k] = aux[i - l];
            i++;
        } else {
            arr[k] = aux[j - l];
            j++;
        }
    }
}

// 对arr[l...r]的范围进行排序
template<typename T>
void __mergeSort(T arr[], int l, int r) {

    // 元素较少时，整个arr近乎有序的概率较大
    // 此时使用insertion sort效率较高
    if (r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }
//    if (l >= r) {
//        return;
//    }
    int mid = l + (r - l) / 2;
    __mergeSort(arr, l, mid);
    __mergeSort(arr, mid + 1, r);

    // 中间两个元素判断是否需要merge
    if (arr[mid] > arr[mid + 1]) {
        __merge(arr, l, mid, r);
    }
}

template<typename T>
void mergeSort(T arr[], int n) {
    // 数组, 开始位置, 结束位置
    __mergeSort(arr, 0, n - 1);
}

int main() {
    int n = 50000;

    cout << "Test for random array, size = " << n << ", random range [0, " << n << "]" << endl;
    int *arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int *arr2 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Insertion Sort", insertionSort, arr1, n);
    SortTestHelper::testSort("Merge Sort", mergeSort, arr2, n);

    delete[] arr1;
    delete[] arr2;

    cout << endl;

    // test for almost sorted array
    int swapTimes = 10;
    assert(swapTimes >= 0);

    cout << "Test for nearly ordered array, size = " << n << ", swap time = " << swapTimes << endl;
    arr1 = SortTestHelper::generateNearlyOrderedArray(n, swapTimes);
    arr2 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Insertion Sort", insertionSort, arr1, n);
    SortTestHelper::testSort("Merge Sort", mergeSort, arr2, n);

    delete[] arr1;
    delete[] arr2;

    return 0;

    return 0;
}