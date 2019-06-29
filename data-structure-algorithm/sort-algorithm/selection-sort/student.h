//
// Created by 王存俊 on 2019-06-29.
//

#ifndef SELECTION_SORT_STUDENT_H
#define SELECTION_SORT_STUDENT_H

#include <iostream>
#include <string>

using namespace std;

struct Student {
    string name;
    int score;

    // 重载运算符
    bool operator<(const Student &otherStudent) {
        return score != otherStudent.score ?
               score > otherStudent.score :
               name < otherStudent.name;
    }

    // 友元函数
    // 输出符重载
    friend ostream &operator<<(ostream &os, const Student &student) {
        os << "Student: " << student.name << " " << student.score << endl;
        return os;
    }

};

#endif //SELECTION_SORT_STUDENT_H
