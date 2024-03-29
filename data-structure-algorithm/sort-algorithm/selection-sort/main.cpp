#include <iostream>
#include "student.h"
#include "SortTestHelper.h"

using namespace std;

// selection sort
// O(n^2)

template<typename T>
void selectionSort(T arr[], int n) {
    for (int i = 0; i < n; i++) {
        // 寻找[i,n)区间中的最小值
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }
}

int main() {

//    int a[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//    selectionSort(a, 10);
//    for (int i = 0; i < 10; i++) {
//        cout << a[i] << " ";
//    }
//    cout << endl;
//
//    float b[10] = {4.4, 3.3, 2.2, 1.1};
//    selectionSort(b, 4);
//    for (int i = 0; i < 4; i++) {
//        cout << b[i] << " ";
//    }
//    cout << endl;
//
//    string c[10] = {"D", "C", "B", "A"};
//    selectionSort(c, 4);
//    for (int i = 0; i < 4; i++) {
//        cout << c[i] << " ";
//    }
//    cout << endl;
//
//    Student d[4] = {{"D", 90},
//                    {"C", 100},
//                    {"B", 95},
//                    {"A", 95}};
//    selectionSort(d, 4);
//    for (int i = 0; i < 4; i++) {
//        cout << d[i];
//    }
//    cout << endl;

    int n = 10000;
    int *arr = SortTestHelper::generateRandomArray(n, 0, n);
//    selectionSort(arr, n);
//    SortTestHelper::printArray(arr, n);
    SortTestHelper::testSort("Selection Sort", selectionSort, arr, n);

    // release array memory space
    delete[] arr;

    return 0;
}