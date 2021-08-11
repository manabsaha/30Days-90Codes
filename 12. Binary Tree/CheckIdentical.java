/* Given two binary trees, the task is to find if both of them are identical or not.  */

class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    // both empty
	    if(root1==null && root2==null){
	        return true;
	    }
	    // both non-empty then compare them
	    if(root1!=null && root2!=null){
	        return (root1.data==root2.data
	        && isIdentical(root1.left,root2.left)
	        && isIdentical(root1.right,root2.right));
	    }
	    // one empty, one not then return false
	    return false;
	}
	
}
