/*Leetcode 110: Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1. */

class Solution
{
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	    if(root==null){
	        return true;
	    }
	    if(!isBalanced(root.left)){
	        return false;
	    }
	    if(!isBalanced(root.right)){
	        return false;
	    }
	    //check heights
	    int lh = height(root.left);
	    int rh = height(root.right);
	    if(Math.abs(lh-rh)<=1){
	        return true;
	    }
	    else{
	        return false;
	    }
    }
    
    private int height(Node root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }
}
