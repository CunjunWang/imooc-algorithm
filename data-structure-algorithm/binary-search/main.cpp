#include <iostream>
#include <vector>
#include <string>
#include "FileOps.h"
#include "SequenceST.h"
#include <queue>
#include <cassert>

using namespace std;

template<typename Key, typename Value>
class BST {

private:
    struct Node {
        Key key;
        Value value;
        Node *left;
        Node *right;

        Node(Key key, Value value) {
            this->key = key;
            this->value = value;
            this->left = this->right = NULL;
        }

        Node(Node *node) {
            this->key = node->key;
            this->value = node->value;
            this->left = node->left;
            this->right = node->right;
        }
    };

    Node *root;
    int count;

public:
    BST() {
        root = NULL;
        count = 0;
    }

    ~BST() {
        // 后序遍历, 释放空间
        destroy(root);
    }

    int size() {
        return count;
    }

    bool isEmpty() {
        return count == 0;
    }

    void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    bool contains(Key key) {
        return contains(root, key);
    }

    Value *search(Key key) {
        return search(root, key);
    }

    // 前序遍历
    void preOrder() {
        preOrder(root);
    }

    // 中序遍历
    void inOrder() {
        inOrder(root);
    }

    // 后序遍历
    void postOrder() {
        postOrder(root);
    }

    // 广度优先, 层序
    void levelOrder() {
        queue<Node *> q;
        q.push(root);
        while (!q.empty()) {
            Node *node = q.front();
            q.pop();
            cout << node->key << endl;
            if (node->left) {
                q.push(node->left);
            }
            if (node->right) {
                q.push(node->right);
            }
        }
    }

    // 寻找最小的键值
    Key minimum() {
        assert(count != 0);
        Node *minNode = minimum(root);
        return minNode->key;
    }

    // 寻找最大的键值
    Key maximum() {
        assert(count != 0);
        Node *maxNode = maximum(root);
        return maxNode->key;
    }

    // 删除最小节点
    void removeMin() {
        if (root) {
            root = removeMin(root);
        }
    }

    // 删除最大节点
    void removeMax() {
        if (root) {
            root = removeMax(root);
        }
    }

    // 删除key节点
    void remove(Key key) {
        root = remove(root, key);
    }

private:

    // 向以node为根的bst插入
    Node *insert(Node *node, Key key, Value value) {
        if (node == NULL) {
            count++;
            return new Node(key, value);
        }
        if (key == node->key) {
            node->value = value;
        } else if (key < node->key) {
            node->left = insert(node->left, key, value);
        } else {
            node->right = insert(node->right, key, value);
        }

        return node;
    }

    // 在以node为根的bst查找key是否存在
    bool contains(Node *node, Key key) {
        if (node == NULL) {
            return false;
        }
        if (key == node->key) {
            return true;
        } else if (key < node->key) {
            return contains(node->left, key);
        } else {
            return contains(node->right, key);
        }
    }

    Value *search(Node *node, Key key) {
        if (node == NULL) {
            return NULL;
        }
        if (key == node->key) {
            return &node->value;
        } else if (key < node->key) {
            return search(node->left, key);
        } else {
            return search(node->right, key);
        }
    }

    void preOrder(Node *node) {
        if (node != NULL) {
            cout << node->key << endl;
            preOrder(node->left);
            preOrder(node->right);
        }
    }

    void inOrder(Node *node) {
        if (node != NULL) {
            inOrder(node->left);
            cout << node->key << endl;
            inOrder(node->right);
        }
    }

    void postOrder(Node *node) {
        if (node != NULL) {
            postOrder(node->left);
            postOrder(node->right);
            cout << node->key << endl;
        }
    }

    void destroy(Node *node) {
        if (node != NULL) {
            destroy(node->left);
            destroy(node->right);
            delete node;
            count--;
        }
    }

    Node *minimum(Node *node) {
        if (node->left == NULL) {
            return node;
        }
        return minimum(node->left);
    }

    Node *maximum(Node *node) {
        if (node->left == NULL) {
            return node;
        }
        return maximum(node->right);
    }

    Node *removeMin(Node *node) {
        if (node->left == NULL) {
            Node *rightNode = node->right;
            delete node;
            count--;
            return rightNode;
        }
        node->left = removeMin(node->left);
        return node;
    }

    Node *removeMax(Node *node) {
        if (node->right == NULL) {
            Node *leftNode = node->left;
            delete node;
            count--;
            return leftNode;
        }
        node->right = removeMax(node->right);
        return node;
    }

    // Hibbard Deletion
    // O(lg(n)), 其实就是找到这个node的时间
    Node *remove(Node *node, Key key) {
        if (node == NULL) {
            return NULL;
        }
        if (key < node->key) {
            node->left = remove(node->left, key);
            return node;
        } else if (key > node->key) {
            node->right = remove(node->right, key);
            return node;
        } else {
            if (node->left == NULL) {
                Node *rightNode = node->right;
                delete node;
                count--;
                return rightNode;
            } else if (node->right == NULL) {
                Node *leftNode = node->left;
                delete node;
                count--;
                return leftNode;
            } else {
                // 为什么要new:
                // cpp中的陷阱: successor指向的是node->right的最小节点
                // 但是之后removeMin把node->right中的最小节点删除了
                // 导致successor指针指向了空, 因此要事先复制一份
                Node *successor = new Node(minimum(node->right));
                count++;
                successor->right = removeMin(node->right);
                successor->left = node->left;
                delete node;
                count--;
                return successor;
            }
        }
    }

};

int main() {
    // 使用圣经作为我们的测试用例
    string filename = "bible.txt";
    vector<string> words;
    if (FileOps::readFile(filename, words)) {

        cout << "There are totally " << words.size() << " words in " << filename << endl;
        cout << endl;


        // 测试 BST
        time_t startTime = clock();

        // 统计圣经中所有词的词频
        BST<string, int> bst = BST<string, int>();
        for (vector<string>::iterator iter = words.begin(); iter != words.end(); iter++) {
            int *res = bst.search(*iter);
            if (res == NULL)
                bst.insert(*iter, 1);
            else
                (*res)++;
        }

        // 输出圣经中god一词出现的频率
        if (bst.contains("god"))
            cout << "'god' : " << *bst.search("god") << endl;
        else
            cout << "No word 'god' in " << filename << endl;

        time_t endTime = clock();

        cout << "BST , time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " s." << endl;
        cout << endl;


        // 测试顺序查找表 SST
        startTime = clock();

        // 统计圣经中所有词的词频
        SequenceST<string, int> sst = SequenceST<string, int>();
        for (vector<string>::iterator iter = words.begin(); iter != words.end(); iter++) {
            int *res = sst.search(*iter);
            if (res == NULL)
                sst.insert(*iter, 1);
            else
                (*res)++;
        }

        // 输出圣经中god一词出现的频率
        if (sst.contain("god"))
            cout << "'god' : " << *sst.search("god") << endl;
        else
            cout << "No word 'god' in " << filename << endl;

        endTime = clock();

        cout << "SST , time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " s." << endl;
    }
    return 0;
}