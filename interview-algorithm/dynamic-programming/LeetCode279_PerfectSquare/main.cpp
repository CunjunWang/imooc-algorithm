#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<int> memo;

    //递归 + 记忆化搜索
    int helper(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int result = INT_MAX;
        // 把比n小的数遍历一遍找平方数, 跟n比较
        for (int i = 1; i * i <= n; i++) {
            result = min(result, 1 + helper(n - i * i));
        }
        memo[n] = result;
        return result;
    }

public:
    int numSquares(int n) {
        memo = vector<int>(n + 1, -1);
        return helper(n);
    }
};

int main() {
    for (int i = 1; i < 26; i++) {
        std::cout << "num square for number " << i << " is " << Solution().numSquares(i) << std::endl;
    }
    return 0;
}