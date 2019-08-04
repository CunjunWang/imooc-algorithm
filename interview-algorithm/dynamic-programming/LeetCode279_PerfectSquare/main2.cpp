//
// Created by 王存俊 on 2019-08-04.
//
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    // DP
    int numSquares(int n) {
        vector<int> memo(n + 1, INT_MAX);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解memo[i];
            for (int j = 1; j * j <= i; j++) {
                memo[i] = min(memo[i], 1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }
};

int main() {
    for (int i = 1; i < 26; i++) {
        std::cout << "num square for number " << i << " is " << Solution().numSquares(i) << std::endl;
    }
    return 0;
}
