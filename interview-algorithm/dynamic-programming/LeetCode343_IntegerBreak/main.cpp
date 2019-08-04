#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
//    vector<int> memo;
//
    int max3(int a, int b, int c) {
        return max(a, max(b, c));
    }
//
//    // 递归解法 + 记忆化搜索
//    // 将n进行分割, 至少要分割两部分, 可以获得最大乘积
//    int breakInteger(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (memo[n] != -1) {
//            return memo[n];
//        }
//        int result = -1;
//        for (int i = 1; i <= n - 1; i++) {
//            // i + (n-i), 这里有坑, 不要忘了 i*(n-i)本身
//            result = max3(result, i * (n - i), i * breakInteger(n - i));
//        }
//        memo[n] = result;
//
//        return result;
//    }

public:
    // dp解法 O(n^2)
    int integerBreak(int n) {
//        memo = vector<int>(n + 1. - 1);
//        return breakInteger(n);

        // memo[i]表示将数字i分割成至少两部分之后得到的最大乘积
        vector<int> memo(n + 1, -1);
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解memo[i], 对i进行分割
            for (int j = 1; j <= i - 1; j++) {
                // j + (i - j)
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}