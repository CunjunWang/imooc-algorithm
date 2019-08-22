#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:

    // 暴力解法：遍历所有连续子数组[i...j]
    // 计算和sum, 验证sum >= s
    // O(n^3);

    // 滑动窗口解法
    int minSubArrayLen(int s, vector<int> &nums) {
        int l = 0, r = -1; // nums[l...r]为滑动窗口
        int sum = 0;
        int res = nums.size() + 1;

        while (l < nums.size()) {
            if (r + 1 < nums.size() && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                res = min(res, r - l + 1);
            }
        }
        if (res == nums.size() + 1) {
            return 0;
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}