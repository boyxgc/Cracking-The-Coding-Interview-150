/*
 * =====================================================================================
 *       Filename:  Q1.cpp
 *    Description:  
 *        Created:  09/04/2014 16:53:39
 *
 *         Author:  Guocheng Xie (boyxgc), boyxgc@gmail.com 
 * =====================================================================================
 */

#include <iostream>
#include <fstream>
#include <errno.h>

using namespace std;

void PrintLastKLines(int lines, char * fname) {

    ifstream file(fname, std::ifstream::binary);
    if(file.is_open()) {
        // seek to the end
        long offset = 0;
        file.seekg(offset, std::ios_base::end);
        size_t fileSize = file.tellg();

        long lineCount = 1;
        do {
            offset--;
            file.seekg(offset, std::ios_base::end);
            // this will move file pointer one step forward
            char ch = file.get();
               
            if(ch == '\n') {
                lineCount++;
            }
        } while((long)fileSize + offset > 0 && file && lineCount <= lines);
        
        // when reading ends before reaching filebegin, move over last '\n'
        if((long)fileSize + offset  > 0) {
           offset++;
        }
        file.seekg(offset, std::ios_base::end);
        
        char ch;
        while(file.good() && (ch = file.get()) != EOF) {
            printf("%c",ch);
            fflush(stdout);
        }

        file.close();
        return fileSize;

    } else {
        printf("Failed to open file %s, %s\n", fname, strerror(errno));
        return 0;
    }
}
