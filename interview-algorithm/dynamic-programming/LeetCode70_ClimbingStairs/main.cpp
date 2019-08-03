#include <iostream>
#include <vector>

using namespace std;

class Solution {
// 递归解法 + 记忆化搜索
private:
    vector<int> memo;

//    int calculateWays(int n) {
//        // if (n == 0) {
//        //     return 1; // 这样 n == 2 就不用判断了
//        // }
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        if (memo[n] == -1) {
//            memo[n] = calculateWays(n - 1) + calculateWays(n - 2);
//        }
//        return memo[n];
//    }

// 动态规划解法
public:
    int climbStairs(int n) {
        vector<int> memo(n + 1, -1);
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}