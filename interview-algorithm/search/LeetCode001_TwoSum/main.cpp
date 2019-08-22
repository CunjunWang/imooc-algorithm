#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    // 暴力解法: O(n^2)

    // trivial: 查找表, 把所有元素放进查找表, 对于每一个元素a, 查找target - a
    // 问题：万一有重复元素呢？后来的index会覆盖之前的index

    // 修改：遍历数组，到v这个数的时候只看v之前的元素有没有target - v
    vector<int> twoSum(vector<int> &nums, int target) {
        map<int, int> record;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            if (record.find(complement) != record.end()) {
                int res[2] = {i, record[complement]};
                return vector<int>(res, res + 2);
            }
            record[nums[i]] = i;
        }
        return {};
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}