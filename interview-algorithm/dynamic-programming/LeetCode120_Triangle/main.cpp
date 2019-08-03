#include <iostream>
#include <vector>

using namespace std;

class Solution {

public:
    int minimumTotal(vector<vector<int>> &triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].size(); j++) {
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }

};

int main() {
    vector<vector<int>> triangle = {{2},
                                    {3, 4},
                                    {6, 5, 7},
                                    {4, 1, 8, 3}};
    std::cout << Solution().minimumTotal(triangle) << std::endl;
    return 0;
}