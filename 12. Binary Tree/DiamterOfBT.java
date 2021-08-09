/* Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. */

class Solution {
    
  // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        
        //base case
        if(root==null){
            return 0;
        }
        
        //root diamter
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int currdiameter = leftheight+rightheight+1;
        
        //when other nodes have largest diameter
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        
        return Math.max(currdiameter,Math.max(ldiameter,rdiameter));
    }
    
  // Function to return the height of a Binary Tree.
    int height(Node root){
        if(root==null){
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight,rheight)+1;
    }
    
}
