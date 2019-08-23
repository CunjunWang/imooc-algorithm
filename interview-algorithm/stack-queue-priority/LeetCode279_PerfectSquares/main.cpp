#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    // dp
//    int numSquares(int n) {
//        vector<int> memo(n + 1, INT_MAX);
//        memo[0] = 0;
//        memo[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            // 求解memo[i];
//            for (int j = 1; j * j <= i; j++) {
//                memo[i] = min(memo[i], 1 + memo[i - j * j]);
//            }
//        }
//        return memo[n];
//    }

    // 图论建模
    int numSquares(int n) {
        queue<pair<int, int>> q;
        q.push(make_pair(n, 0));

        vector<bool> visited(n + 1, false);
        visited[n] = true;

        while (!q.empty()) {
            int num = q.front().first;
            int step = q.front().second;
            q.pop();
            if (num == 0) {
                return step;
            }
            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num - i * i]) {
                    q.push(make_pair(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        return 0;
    }

};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}