/* Function to find the height of a binary tree.
Approach: Find height of the left subtree and find height of the right subtree. Return max of it. */

class Solution {
    int height(Node root) 
    {
        if(root==null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight,rightheight) + 1;
    }
}
