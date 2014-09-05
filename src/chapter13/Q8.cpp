/*
 * =====================================================================================
 *       Filename:  Q8.cpp
 *    Description:  Implement a smart pointer class. A smart pointer is a data type, 
 *                  usually implemented with templates, that simulates a pointer while
 *                  also providing automatic garbage collection. It automatically counts
 *                  the number of references to a SmartPointer<T*> object and frees the
 *                  object of type T when the reference counts hit zero.
 *
 *        Created:  09/04/2014 23:05:53
 *
 *         Author:  Guocheng Xie (boyxgc), boyxgc@gmail.com
 * =====================================================================================
 */

template <class T>
class SmartPointer {

  protected:
    T * ref;
    unsigned * ref_count;

  public:
    SmartPointer(T * obj) {
        ref = obj;
        ref_count = (unsigned *)malloc(sizeof(unsigned));
        *ref_count = 1;
    }

    SmartPointer(SmartPointer<T> & ptr) {
        ref = ptr.ref;
        ref_count = ptr.ref_count;
        ++(*ref_count);
    }

    ~SmartPointer() {
        --(*ref_count);
        if(*ref_count == 0) {
            delete ref;
            free(ref_count);
            ref = NULL;
            ref_count = NULL;
        }
    }

};
