#include <iostream>

using namespace std;

class Solution {
public:

    // 滑动窗口解法
    // 一边滑动, 一边做记录
    // 如何记录重复字符? freq[256], 因为一共有256个ASCII
    int lengthOfLongestSubstring(string s) {
        int freq[256] = {0};
        int l = 0, r = -1; // 滑动窗口为s[l...r]
        int res = 0;

        while (l < s.size()) {
            if (r + 1 < s.size() && freq[s[r + 1]] == 0) {
                r++;
                freq[s[r]]++;
            } else {
                freq[s[l]]--;
                l++;
            }
            res = max(res, r - l + 1);
        }

        return res;
    }
};


int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}