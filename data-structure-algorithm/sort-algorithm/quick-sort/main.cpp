#include <iostream>
#include <algorithm>
#include "MergeSort.h"
#include "InsertionSort.h"
#include "SortTestHelper.h"

using namespace std;

// 对arr[l...r]进行partition
// 返回索引值: 使得arr[l...p-1] < arr[p], arr[p+1...r] > arr[p]
template<typename T>
int __partition(T arr[], int l, int r) {

    swap(arr[l], arr[rand() % (r - l + 1) + l]);

    T v = arr[l];

    // arr[l+1...j] < v, arr[j+1...i] > v
    int j = l;
    for (int i = l + 1; i <= r; i++) {
        if (arr[i] < v) {
            // swap(arr[++j], arr[i]);
            swap(arr[j + 1], arr[i]);
            j++;
        }
    }
    swap(arr[l], arr[j]);
    return j;
}

// 对arr[l...r]进行quick sort
template<typename T>
void __quickSort(T arr[], int l, int r) {
//    if (l >= r) {
//        return;
//    }
    // 优化: 高级排序算法到底层可以用插入排序加快速度
    if (r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }

    int p = __partition(arr, l, r);
    __quickSort(arr, l, p - 1);
    __quickSort(arr, p + 1, r);
}

template<typename T>
void quickSort(T arr[], int n) {
    // 优化: 随机选择一个pivot
    srand(time(NULL));
    __quickSort(arr, 0, n - 1);
}

int main() {

    int n = 1000000;

    cout << "Test for Random array, size = " << n << ", random range [0, " << n << "]" << endl;
    int *arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int *arr2 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);

    delete[] arr1;
    delete[] arr2;

    cout << endl;

    // merge sort可以保证每次的划分 两部分大小相同
    // quick sort不可保证递归树的高度是log(n)
    // 当整个array近乎有序时, 基础的quick sort效率非常低
    // 最差情况, quick sort退化为O(n^2)
    // 优化: 随机选择一个pivot, 而不是每次取数组第一个作为pivot

    int swapTimes = 100;

    cout << "Test for Random nearly sorted array, size = " << n << ", swap times = " << swapTimes << endl;
    arr1 = SortTestHelper::generateNearlyOrderedArray(n, swapTimes);
    arr2 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);

    delete[] arr1;
    delete[] arr2;


    return 0;
}