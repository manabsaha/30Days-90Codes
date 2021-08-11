/* Given a binary tree, replace each node sum of itself, left node and right node.
In case of leaf, the value remains unchanged. */

class Solution{
    public void toSumTree(Node root){
         if(root==null){
             return;
         }
         toSumTree(root.left);
         toSumTree(root.right);
         if(root.left!=null){
             root.data += root.left.data;
         }
         if(root.right!=null){
             root.data += root.right.data;
         }
    }
}
