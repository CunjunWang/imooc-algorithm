#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    vector<vector<int>> result;

    vector<bool> used;

    void generatePermutation(const vector<int> &nums, int index, vector<int> &p) {
        if (index == nums.size()) {
            result.push_back(p);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (!used[i]) {
                // 把nums[i]添加到p中
                p.push_back(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                // 恢复原状 - 回溯的本质
                p.pop_back();
                used[i] = false;
            }
        }
    }

public:
    vector<vector<int>> permute(vector<int> &nums) {
        result.clear();
        if (nums.empty())
            return result;
        used = vector<bool>(nums.size(), false);
        vector<int> p;
        generatePermutation(nums, 0, p);
        return result;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}