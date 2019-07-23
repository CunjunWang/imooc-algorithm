//
// Created by 王存俊 on 2019-07-23.
//

#ifndef BINARY_SEARCH_BINARYSEARCH_H
#define BINARY_SEARCH_BINARYSEARCH_H

// 二分查找, 在sorted array arr中找到target
// 如果找到了, 返回index
// 如果没找到返回-1
template<typename T>
int binarySearch(T arr[], int n, T target) {
    // invariant: 在arr[l...r]之中查找target
    int l = 0, r = n - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        // 在arr[l...mid-1]之中查找target
        if (target < arr[mid]) {
            r = mid - 1;
            continue;
        }
        // 在arr[mid+1...r]之中查找target
        if (target > arr[mid]) {
            l = mid + 1;
            continue;
        }
    }
    return -1;
}

#endif //BINARY_SEARCH_BINARYSEARCH_H
