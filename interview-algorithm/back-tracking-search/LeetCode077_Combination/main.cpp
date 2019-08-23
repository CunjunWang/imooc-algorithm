#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<vector<int>> result;

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    void generateCombinations(int n, int k, int start, vector<int> &c) {
        if (c.size() == k) {
            result.push_back(c);
            return;
        }

        // 优化: 递归树剪枝prune
        // 还有 k - c.size() 个空位
        // [i...n] 至少要有 k - c.size() 个元素
        // i 最多为 n - (k - c.size()) + 1
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.push_back(i);
            generateCombinations(n, k, i + 1, c);
            // 回溯
            c.pop_back();
        }
    }

public:
    vector<vector<int>> combine(int n, int k) {
        result.clear();
        if (n <= 0 || k <= 0 || k > n)
            return result;
        vector<int> c;
        generateCombinations(n, k, 1, c);
        return result;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}