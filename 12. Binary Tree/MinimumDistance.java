/* Given a binary tree and two node values your task is to find the minimum distance between them. 
Approach: Find lca of node1 and node 2
return Distance from lca to node1 + Distance from lca to node2 */

class Solution {
    int findDist(Node root, int n1, int n2) {
        Node lcanode = LCA(root, n1, n2);
		int d1 = getPath(lcanode, n1, 0);
		int d2 = getPath(lcanode, n2, 0);
		return d1+d2;
    }
    
    //lowest common ancestor node
	Node LCA(Node root,int n1,int n2){
		if(root==null){
			return null;
		}
		//if found in root
		if(root.data==n1 || root.data==n2){
			return root;
		}
		//search lca in left & right
		Node left = LCA(root.left,n1,n2);
		Node right = LCA(root.right,n1,n2);
		//if lca is found
		if (left!=null && right!=null)
            return root;
        // Otherwise check if left subtree or right subtree is LCA
        if(left != null){
            return left;
        }
        else{
            return right;
        }
	}

	//find the distance b/w two nodes
	int getPath(Node root,int k,int dist){
		if(root==null){
			return -1;
		}
		if(root.data==k){
			return dist;
		}
		int left = getPath(root.left,k,dist+1);
		if(left!=-1){
			return left;
		}
		int right = getPath(root.right,k,dist+1);
		return right;
	}
}
