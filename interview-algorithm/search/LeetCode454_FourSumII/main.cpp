#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // 暴力解法：O(n^4)

    // 把C + D中的每一种可能放进查找表 O(n^2), space O(n^2)
    int fourSumCount(vector<int> &A, vector<int> &B, vector<int> &C, vector<int> &D) {
        unordered_map<int, int> record;
        for (int i = 0; i < C.size(); i++) {
            for (int j = 0; j < D.size(); j++) {
                record[C[i] + D[j]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if (record.find(0 - A[i] - B[j]) != record.end()) {
                    res += record[0 - A[i] - B[j]];
                }
            }
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}