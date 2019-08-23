#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Solution {
private:
    vector<string> result;
    const string letterMap[10] = {
            " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // s保存的是此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    void findCombination(const string &digits, int index, const string &s) {
        if (index == digits.size()) {
            result.push_back(s);
            return;
        }
        char c = digits[index];
        assert(c >= '0' && c <= '9' && c != '1');
        string letters = letterMap[c - '0'];
        for (int i = 0; i < letters.size(); i++) {
            findCombination(digits, index + 1, s + letters[i]);
        }
        return;
    }

public:
    vector<string> letterCombinations(string digits) {
        if (digits == "")
            return result;
        findCombination(digits, 0, "");
        return result;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}