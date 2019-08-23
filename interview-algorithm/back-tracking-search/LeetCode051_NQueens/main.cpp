#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<vector<string>> res;
    vector<bool> col, diag1, diag2;

    vector<string> generateBoard(int n, vector<int> &row) {
        assert(row.size() == n);
        vector<string> board(n, string(n, '.'));
        for (int i = 0; i < n; i++) {
            board[i][row[i]] = 'Q';
        }
        return board;
    }

    // 尝试在n皇后问题中, 摆放第index行皇后位置
    void putQueen(int n, int index, vector<int> &row) {
        if (index == n) {
            res.push_back(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试把第index行的皇后摆放在第i列
            if (!col[i] && !diag1[index + i] && !diag2[index - i + n - 1]) {
                row.push_back(i);
                col[i] = true;
                diag1[index + i] = true;
                diag2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                // 回溯
                col[i] = false;
                diag1[index + i] = false;
                diag2[index - i + n - 1] = false;
                row.pop_back();
            }
        }

    }

public:
    vector<vector<string>> solveNQueens(int n) {
        res.clear();
        col = vector<bool>(n, false);
        diag1 = vector<bool>(2 * n - 1, false);
        diag2 = vector<bool>(2 * n - 1, false);
        vector<int> row;
        putQueen(n, 0, row);
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}