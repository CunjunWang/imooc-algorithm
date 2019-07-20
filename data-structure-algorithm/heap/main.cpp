#include <iostream>

#include <algorithm>
#include <string>
#include <ctime>
#include <cmath>
#include <cassert>

using namespace std;

template<typename Item>
class MaxHeap {

private:
    Item *data;
    int count;

public:
    MaxHeap(int capacity) {
        // 从 index = 1 开始存储所以要 +1
        data = new Item[capacity + 1];
        count = 0;
    }

    ~MaxHeap() {
        delete[] data;
    }

    int size() {
        return count;
    }

    bool isEmpty() {
        return count == 0;
    }

};

int main() {
    MaxHeap<int> maxHeap = MaxHeap<int>(100);
    cout << maxHeap.size() << endl;
    return 0;
}