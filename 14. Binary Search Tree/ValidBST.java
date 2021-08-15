/*Leetcode 98:
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees. */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }
    
    public boolean isBST(TreeNode root, TreeNode min, TreeNode max){
        // base
        if(root==null) return true;
        // when min-max not satisfied.
        if(min!=null && root.val<=min.val){
            return false;
        }
        if(max!=null && root.val>=max.val){
            return false;
        }
        //check validity for left and right subtree.
        boolean left = isBST(root.left,min,root);
        boolean right = isBST(root.right,root,max);
        return (left&&right);   
    }
}
