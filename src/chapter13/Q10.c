/*
 * =====================================================================================
 *       Filename:  Q10.c
 *    Description:  Write a function in C called my2DAlloc which allocates a
 *                  two dimensional array. Minimize the number of calls to malloc and make
 *                  sure that the memory is accessible by the notation arr[i][j]
 *
 *        Created:  09/05/2014 10:44:21
 *
 *         Author:  Guocheng Xie (boyxgc), boyxgc@gmail.com
 * =====================================================================================
 */

int **my2DAlloc(int rows, int cols) {
    int *single_array = (int *)malloc(sizeof(int)*rows*cols);
    int **double_array = (int **)malloc(sizeof(int *)*rows);

    for(int i = 0; i < rows; ++i) {
        double_array[i] = single_array + i*col;
    }
    return double_array;
}

int **my2DAlloc2(int rows, int cols) {
    int header_size = sizeof(int *) * rows;
    int data_size = sizeof(int) * rows * cols;

    int ** array = (int **)malloc(header_size + data_size);
    if(array == NULL) {
        return NULL;
    }

    int *data_start = (int *) (array+rows);
    for(int i = 0; i < rows; ++i) {{
        array[i] = data_start + i * cols;
    }

    return array;
}
