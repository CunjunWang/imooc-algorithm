#include <iostream>
#include <vector>

// brute force: O((2^n)*n)

using namespace std;

class Solution {

// 初始递归解法
// 考虑去抢劫nums[index...nums.size())这个范围内的所有房子
// private:
//    int tryRob(vector<int> &nums, int index) {
//        if (index >= nums.size()) return 0;
//
//        int result = 0;
//        for (int i = index; i < nums.size(); i++) {
//            result = max(result, nums[i] + tryRob(nums, i + 2));
//        }
//
//        return result;
//    }

// 记忆化搜索解法
// memo[i]表示考虑抢劫nums[i...n)获得的最大收益
// private:
//    vector<int> memo;
//
//    int tryRob(vector<int> &nums, int index) {
//        if (index >= nums.size()) return 0;
//        if (memo[index] != -1) {
//            return memo[index];
//        }
//        int result = 0;
//        for (int i = index; i < nums.size(); i++) {
//            result = max(result, nums[i] + tryRob(nums, i + 2));
//        }
//        memo[index] = result;
//        return result;
//    }
//
//public:
//    int rob(vector<int> &nums) {
//        memo = vector<int>(nums.size(), -1);
//        return tryRob(nums, 0);
//    }

// 动态规划解法
public:
    int rob(vector<int> &nums) {
        int n = nums.size();
        if (n == 0) return 0;
        // memo[i]表示考虑抢劫nums[i...n-1]获得的最大收益
        vector<int> memo(n, -1);
        memo[n - 1] = nums[n - 1];
        // 注意, 按照memo的定义, memo[0]是这个问题的最终结果
        // 并且memo[n-1]是这个问题的最简形式了
        // 因此倒推回去
        for (int i = n - 2; i >= 0; i--) {
            // memo[i]
            for (int j = i; i < n; j++) {
                memo[i] = max(memo[i],
                              nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}