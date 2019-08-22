#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Knapsack01 {
private:
    // 添加记忆化搜索
//    vector<vector<int>> memo;

    // 用[0...index]的物品, 填充容积为c的背包的最大价值
//    int bestValue(const vector<int> &w, const vector<int> v, int index, int c) {
//        if (index < 0 || c <= 0) return 0;
//        if (memo[index][c] != -1) {
//            return memo[index][c];
//        }
//        int res = bestValue(w, v, index - 1, c);
//        if (c >= w[index]) {
//            res = max(res,
//                      v[index] + bestValue(w, v, index - 1, c - w[index]));
//        }
//        memo[index][c] = res;
//        return res;
//    }

public:
    int knapsack01(const vector<int> &w, const vector<int> &v, int C) {
//        int n = w.size();
//        memo = vector<vector<int>>(n, vector<int>(C + 1, -1));
//        return bestValue(w, v, n - 1, C);

        // dp解法, 自底向上 O(nC), space O(nC)
        assert(w.size() == v.size());
        int n = w.size();
        if (n == 0) return 0;

        // space优化, 优化后为O(C)
        // vector<vector<int>> memo(2, vector<int>(C + 1, -1));
        vector<int> memo(C + 1, -1);
        // 只考虑0号物品
        for (int j = 0; j <= C; j++) {
            memo[j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                memo[j] = max(memo[j], v[i] + memo[j - w[i]]);
            }
        }

        return memo[C];
    }

};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}