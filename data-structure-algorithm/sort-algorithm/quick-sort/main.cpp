#include <iostream>
#include <algorithm>
#include "MergeSort.h"
#include "QuickSort.h"
#include "QuickSortTwoWay.h"
#include "InsertionSort.h"
#include "SortTestHelper.h"

using namespace std;

// 三路快速排序
// 把arr[l...r]分为 <v; =v; >v 三部分
// 递归对 <v, >v 进行三路快速排序
template<typename T>
void __quickSortThreeWay(T arr[], int l, int r) {
    if (r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }

    // partition
    swap(arr[l], arr[rand() % (r - l + 1) + l]);
    T v = arr[l];

    int lt = l; // arr[l+1...lt] < v;
    int gt = r + 1; // arr[gt...r] > v;
    int i = l + 1; // arr[lt+1...i) = v;

    while (i < gt) {
        if (arr[i] < v) {
            swap(arr[i], arr[lt + 1]);
            lt++;
            i++;
        } else if (arr[i] > v) {
            swap(arr[i], arr[gt - 1]);
            gt--;
        } else { // arr[i] == v;
            i++;
        }
    }

    swap(arr[l], arr[lt]);

    __quickSortThreeWay(arr, l, lt - 1);
    __quickSortThreeWay(arr, gt, r);

}

template<typename T>
void quickSortThreeWay(T arr[], int n) {
    srand(time(NULL));
    __quickSortThreeWay(arr, 0, n - 1);
}

int main() {

    int n = 1000000;

    cout << "Test for Random array, size = " << n << ", random range [0, " << n << "]" << endl;
    int *arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int *arr2 = SortTestHelper::copyIntArray(arr1, n);
    int *arr3 = SortTestHelper::copyIntArray(arr1, n);
    int *arr4 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick Sort Two Way", quickSortTwoWay, arr3, n);
    SortTestHelper::testSort("Quick Sort Three Way", quickSortThreeWay, arr4, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;

    cout << endl;

    // ============================ 近乎有序的数组进行快速排序 ============================

    // merge sort可以保证每次的划分 两部分大小相同
    // quick sort不可保证递归树的高度是log(n)
    // 当整个array近乎有序时, 基础的quick sort效率非常低
    // 最差情况, quick sort退化为O(n^2)
    // 优化: 随机选择一个pivot, 而不是每次取数组第一个作为pivot

    int swapTimes = 100;

    cout << "Test for Random nearly sorted array, size = " << n << ", swap times = " << swapTimes << endl;
    arr1 = SortTestHelper::generateNearlyOrderedArray(n, swapTimes);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);
    arr4 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick Sort Two Way", quickSortTwoWay, arr3, n);
    SortTestHelper::testSort("Quick Sort Three Way", quickSortThreeWay, arr4, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;

    cout << endl;

    // ============================ 大量重复元素的数组进行快速排序 ============================

    // 问题类似, 极其容易把array分为不平衡的两部分

    int range = 10;
    cout << "Test for Random array, size = " << n << ", random range [0, " << range << "]" << endl;
    arr1 = SortTestHelper::generateRandomArray(n, 0, range);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);
    arr4 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick Sort Two Way", quickSortTwoWay, arr3, n);
    SortTestHelper::testSort("Quick Sort Three Way", quickSortThreeWay, arr4, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;

    return 0;
}