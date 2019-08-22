#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // 暴力解法 O(n^3)

    // O(n^2), 空间O(n)
    int numberOfBoomerangs(vector<vector<int>> &points) {
        int res = 0;

        for (int i = 0; i < points.size(); i++) {
            // 记录其余所有点到当前点不同的距离的平方出现的频次
            unordered_map<int, int> record;
            for (int j = 0; j < points.size(); j++) {
                if (j != i) {
                    record[dis(points[i], points[j])]++;
                }
            }
            for (auto iter = record.begin(); iter != record.end(); iter++) {
                res += (iter->second) * (iter->second - 1);
            }
        }

        return res;
    }

private:
    long long dis(const vector<int> &pa, const vector<int> &pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
               (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}