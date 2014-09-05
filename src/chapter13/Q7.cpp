/*
 * =====================================================================================
 *       Filename:  Q7.cpp
 *    Description:  Write a method that takes a pointer to a Node structure as a parameter
 *                  and returns a complete copy of the passed in data structure. The Node 
 *                  data structure contains two pointers to other Node
 *
 *        Created:  09/04/2014 22:47:37
 *
 *         Author:  Guocheng Xie (boyxgc), boyxgc@gmail.com
 * =====================================================================================
 */

#include <unordered_map>

class Node {
  public :
    Node *left;
    Node *right;
};

Node * copy(Node *node) {
   unordered_map<Node *, Node *> map;

   return copy(node, map);
}

Node *copy(Node *node, unordered_map<Node *, Node *> &map) {
    if(node == NULL) 
        return NULL;

    unordered_map<Node *, Node*>::iterator i = map.find(node);
    if(i != map.end(){
        return i->second; 
    }

    Node *newnode = new Node();
    newnode->left = copy(node->left, map);
    newnode->right = copy(node->right, map);

    unordered_map[node] = newnode;

    return newnode;
}
