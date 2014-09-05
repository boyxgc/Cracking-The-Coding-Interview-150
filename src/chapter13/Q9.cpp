/*
 * =====================================================================================
 *       Filename:  Q9.cpp
 *    Description:  Implement a aligned_malloc and free function that supports allocating
 *                  memory such that the memory address returned is divisible by a specific
 *                  power of two.
 *    
 *        Created:  09/04/2014 23:40:06
 *
 *         Author:  Guocheng Xie (boyxgc), boyxgc@gmail.com
 * =====================================================================================
 */

void * aligned_malloc(size_t size, size_t alignment) {
    int offset = alignment - 1 + sizeof(void *);
    void * p1  = (void *)malloc(size +  offset);
    if(p1 == NULL) {
        return NULL;
    }
    void **p2 = (void**)(((size_t)(p1) + offset) & ~(alignment -1));
    p2[-1] = p1;

    return p2;
}

void aligned_free(void * p2) {
    void *p1 = ((void **)p2)[-1];

    return p1;
}

