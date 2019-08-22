#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:

    // 暴力解法：双层遍历 O(n^2)

    // 暴力解法没有利用数组的有序性
    // 搜索的时候可以用二分搜索
    // 对于每一个数，在剩余的数组中二分查找target - nums[i]
//    vector<int> twoSum(vector<int> &numbers, int target) {
//        vector<int> res(2, -1);
//        int size = numbers.size();
//        for (int i = 0; i < size; i++) {
//            int low = i + 1;
//            int high = size - 1;
//            int mid = low + (high - low) / 2;
//            int t = target - numbers[i];
//            while (low <= high) {
//                if (numbers[mid] == t) {
//                    res[0] = i;
//                    res[1] = mid;
//                    return res;
//                } else if (numbers[mid] < t) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//        }
//        return res;
//    }

    // 对撞指针解法 (利用了数组有序性) O(n)
    vector<int> twoSum(vector<int> &numbers, int target) {
        assert(numbers.size() >= 2);
        vector<int> res(2, -1);
        int i = 0;
        int j = numbers.size() - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}