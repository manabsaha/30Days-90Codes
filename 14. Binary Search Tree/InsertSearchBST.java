/*Insert and Search operation in BST */

class Node{
	int data;
	Node left = null;
	Node right = null;
	Node(int v){
		this.data = v;
	}
}

class BST{
	public static void main(String[] args){
		Node root = new Node(30);
		Solution obj = new Solution();
		//insert
		obj.insertBST(root,20);
		obj.insertBST(root,40);
		obj.insertBST(root,10);
		obj.insertBST(root,35);
		obj.insertBST(root,12);
		//display
		obj.inorder(root);
		//search
		if(obj.searchBST(root,35)!=null){
			System.out.println("\nElement found!");
		}
		else{
			System.out.println("\nElement not found!");	
		}
	}
}

class Solution{
	public Node insertBST(Node root,int val){
		if(root==null){
			return new Node(val);
		}
		/* If you don't want same value to repeat, uncomment. */
		/*if(root.data==val){
		    return root;
		}*/
		if(val<root.data){
			root.left = insertBST(root.left,val);
		}
		else{
			root.right = insertBST(root.right,val);
		}
		return root;
	}

	public void inorder(Node root){
		if(root==null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	public Node searchBST(Node root,int el){
		if(root==null){
			return null;
		}
		if(root.data == el){
			return root;
		}
		if(el<root.data){
			return searchBST(root.left,el);
		}
		return searchBST(root.right,el);
	}
}

