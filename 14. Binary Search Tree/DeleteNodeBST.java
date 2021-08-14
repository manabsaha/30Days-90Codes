/* Delete a node from a BST by honouring the BST property.
Handle the 4 cases:
1) when it is left nodes -> simply detach
2) when left or right child only -> link to left or right child by removing the node
3) when both child are present, take max of left subtree and change it with current node and replace
it with current node and delete it from the left subtree. */

class Tree
{
    private int getMax(Node root){
		if(root.right!=null){
			return getMax(root.right);
		}
		else{
			return root.data;
		}
	}

	public Node deleteNode(Node root,int el){
		//base case.
		if(root==null){
			return null;
		}
		//search the element node.
		if(el<root.data){
			root.left = deleteNode(root.left,el);
		}
		else if(el>root.data){
			root.right = deleteNode(root.right,el);
		}
		//if found
		else{
			// case when both child are present.
			// find the max in its left subtree and replace it with the current
			// and remove the max from left subtree.
			if(root.left!=null && root.right!=null){
				int lmax = getMax(root.left);
				root.data = lmax;
				root.left = deleteNode(root.left,lmax);
				return root;
			}
			// case, only left node.
			else if(root.left!=null){
				return root.left;
			}
			// case, only right node.
			else if(root.right!=null){
				return root.right;
			}
			// case, leaf node.
			else{
				return null;
			}
		}
		return root;
	}
}	
