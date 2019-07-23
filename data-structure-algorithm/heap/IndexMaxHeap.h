//
// Created by 王存俊 on 2019-07-22.
//

#ifndef HEAP_INDEXMAXHEAP_H
#define HEAP_INDEXMAXHEAP_H

#include <algorithm>
#include <cassert>
#include <cmath>

using namespace std;

template<typename Item>
class IndexMaxHeap {

private:
    Item *data;
    int *indices;
    int *reverse;
    int count;
    int capacity;

    void shiftUp(int k) {
        while (k > 1 && data[indices[k / 2]] < data[indices[k]]) {
            swap(indices[k / 2], indices[k]);
            reverse[indices[k / 2]] = k / 2;
            reverse[indices[k]] = k;
            k /= 2;
        }
    }

    void shiftDown(int k) {
        // k节点必须有child
        // 由于heap是完全二叉树, 只要判断是否有left child
        // left child的index是2k
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indices[j + 1]] > data[indices[j]]) {
                j += 1;
            }
            if (data[indices[k]] >= data[indices[j]]) {
                break;
            }
            swap(indices[k], indices[j]);
            reverse[indices[k]] = k;
            reverse[indices[j]] = j;
            k = j;
        }
    }

    void putNumberInLine(int num, string &line, int index_cur_level, int cur_tree_width, bool isLeft) {

        int sub_tree_width = (cur_tree_width - 1) / 2;
        int offset = index_cur_level * (cur_tree_width + 1) + sub_tree_width;
        assert(offset + 1 < line.size());
        if (num >= 10) {
            line[offset + 0] = '0' + num / 10;
            line[offset + 1] = '0' + num % 10;
        } else {
            if (isLeft)
                line[offset + 0] = '0' + num;
            else
                line[offset + 1] = '0' + num;
        }
    }

    void putBranchInLine(string &line, int index_cur_level, int cur_tree_width) {

        int sub_tree_width = (cur_tree_width - 1) / 2;
        int sub_sub_tree_width = (sub_tree_width - 1) / 2;
        int offset_left = index_cur_level * (cur_tree_width + 1) + sub_sub_tree_width;
        assert(offset_left + 1 < line.size());
        int offset_right = index_cur_level * (cur_tree_width + 1) + sub_tree_width + 1 + sub_sub_tree_width;
        assert(offset_right < line.size());

        line[offset_left + 1] = '/';
        line[offset_right + 0] = '\\';
    }

public:
    IndexMaxHeap(int capacity) {
        // 从 index = 1 开始存储所以要 +1
        data = new Item[capacity + 1];
        indices = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this->capacity = capacity;
    }

    ~IndexMaxHeap() {
        delete[] data;
        delete[] indices;
        delete[] reverse;
    }

    int size() {
        return count;
    }

    bool isEmpty() {
        return count == 0;
    }

    // i 对于用户而言, 从0开始计算
    void insert(int i, Item item) {
        assert(count + 1 <= capacity);
        assert(i + 1 >= 1 && i + 1 <= capacity);
        i += 1;
        data[i] = item;
        indices[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    Item extractMax() {
        assert(count > 0);
        Item ret = data[indices[1]];
        swap(indices[1], indices[count]);
        reverse[indices[1]] = 1;
        reverse[indices[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    int extractMaxIndex() {
        assert(count > 0);
        int ret = indices[1] - 1;
        swap(indices[1], indices[count]);
        reverse[indices[1]] = 1;
        reverse[indices[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    bool contains(int i) {
        assert(i + 1 >= 0 && i + 1 <= capacity);
        return reverse[i + 1] != 0;
    }

    Item getItem(int i) {
        assert(contains(i));
        return data[i + 1];
    }

    void change(int i, Item newItem) {
        assert(contains(i));
        i += 1;
        data[i] = newItem;

        // 找到indices[j] = i, j表示data[i]在heap中的位置
        // 之后shiftUp(j), shiftDown(j);
//        for (int j = 1; j <= count; j++) {
//            if (indices[j] == i) {
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }
//        }
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    // 以树状打印整个堆结构
    void testPrint() {

        // 我们的testPrint只能打印100个元素以内的堆的树状信息
        if (size() >= 100) {
            cout << "This print function can only work for less than 100 int";
            return;
        }

        // 我们的testPrint只能处理整数信息
        if (typeid(Item) != typeid(int)) {
            cout << "This print function can only work for int item";
            return;
        }

        cout << "The max heap size is: " << size() << endl;
        cout << "Data in the max heap: ";
        for (int i = 1; i <= size(); i++) {
            // 我们的testPrint要求堆中的所有整数在[0, 100)的范围内
            assert(data[i] >= 0 && data[i] < 100);
            cout << data[i] << " ";
        }
        cout << endl;
        cout << endl;

        int n = size();
        int max_level = 0;
        int number_per_level = 1;
        while (n > 0) {
            max_level += 1;
            n -= number_per_level;
            number_per_level *= 2;
        }

        int max_level_number = int(pow(2, max_level - 1));
        int cur_tree_max_level_number = max_level_number;
        int index = 1;
        for (int level = 0; level < max_level; level++) {
            string line1 = string(max_level_number * 3 - 1, ' ');

            int cur_level_number = min(count - int(pow(2, level)) + 1, int(pow(2, level)));
            bool isLeft = true;
            for (int index_cur_level = 0; index_cur_level < cur_level_number; index++, index_cur_level++) {
                putNumberInLine(data[index], line1, index_cur_level, cur_tree_max_level_number * 3 - 1, isLeft);
                isLeft = !isLeft;
            }
            cout << line1 << endl;

            if (level == max_level - 1)
                break;

            string line2 = string(max_level_number * 3 - 1, ' ');
            for (int index_cur_level = 0; index_cur_level < cur_level_number; index_cur_level++)
                putBranchInLine(line2, index_cur_level, cur_tree_max_level_number * 3 - 1);
            cout << line2 << endl;

            cur_tree_max_level_number /= 2;
        }
    }
};

#endif //HEAP_INDEXMAXHEAP_H
