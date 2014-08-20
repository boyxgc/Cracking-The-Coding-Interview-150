/*
 * =====================================================================================
 *       Filename:  Q2.cpp
 *        Created:  08/20/2014 11:22:20
 *       Compiler:  gcc
 *
 *         Author:  Devin Guocheng Xie (gc), guochenx@usc.edu
 * =====================================================================================
 */
#include <iostream>
using namespace std;

/*
 *implement a reverse function which reverses a null-terminated string
 */
char* reverse(char * str) {
    if(!str) return NULL;

    char * head = str;
    char * end = str;
    while(*end) {
        ++end;
    }

    --end;

    while(head < end) {
        char tmp = *head;
        *head++ = *end;
        *end-- = tmp;
    }

    return str;
}

int main() {
    char * str = new char[10];
    strcpy(str, "hello\0world");

    printf("#%s#\n", reverse(str));
    return 0;
}
