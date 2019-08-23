#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<string> binaryTreePaths(TreeNode *root) {
        vector<string> result;

        if (!root)
            return result;

        if (!root->left && !root->right) {
            result.push_back(to_string(root->val));
            return result;
        }

        vector<string> leftString = binaryTreePaths(root->left);
        for (int i = 0; i < leftString.size(); i++) {
            result.push_back(to_string(root->val) + "->" + leftString[i]);
        }

        vector<string> rightString = binaryTreePaths(root->right);
        for (int i = 0; i < rightString.size(); i++) {
            result.push_back(to_string(root->val) + "->" + rightString[i]);
        }

        return result;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}