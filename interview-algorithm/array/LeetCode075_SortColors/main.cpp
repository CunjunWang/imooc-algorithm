#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    // method 1 : 直接libray方法
//    void sortColors(vector<int>& nums) {
//        sort(nums.begin(), nums.end());
//    }

    // method 2 : 计数排序
    // 统计每个元素的数量, 再依次放回数组
//    void sortColors(vector<int> &nums) {
//        int count[3] = {0}; // 存放0,1,2三个元素的频率
//        for (int i = 0; i < nums.size(); i++) {
//            assert(nums[i] >= 0 && nums[i] <= 2);
//            count[nums[i]]++;
//        }
//
//        int index = 0;
//        for (int i = 0; i < count[0]; i++) {
//            nums[index++] = 0;
//        }
//        for (int i = 0; i < count[1]; i++) {
//            nums[index++] = 1;
//        }
//        for (int i = 0; i < count[2]; i++) {
//            nums[index++] = 2;
//        }
//    }

    // method 3 : 三路快速排序
    void sortColors(vector<int> &nums) {
        int zero = -1; // nums[0...zero] == 0;
        int two = nums.size(); // nums[two...n-1] == 2;

        for (int i = 0; i < two;) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums[i], nums[--two]);
            } else {
                assert(nums[i] == 0);
                zero++;
                swap(nums[zero], nums[i]);
                i++;
            }
        }
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}