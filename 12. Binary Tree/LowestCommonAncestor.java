/* Given a Binary Tree with all unique values and two nodes value n1 and n2. The task is to find the lowest common ancestor of the given two nodes. 
We may assume that either both n1 and n2 are present in the tree or none of them is present. 
Approach: 
1) Find path from root to n1
2) Find path from root to n2
3) Return the last common node in the two paths. */

public class Tree{	
	public static void main(String[] args){
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(60);
		root.left.right = new Node(40);
		root.right.left = new Node(70);
		root.right.right = new Node(50);
		Solution obj = new Solution();
		System.out.println("Lowest common ancestor: "+obj.LCA(root,20,60).data);
	}
}

class Solution
{
	public Node LCA(Node root, int n1,int n2)
	{
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		
		//if key does not exist
		if(!getPath(root,n1,path1) || !getPath(root,n2,path2)){
			return null;
		}
		
		// changing point
		int i;
		for(i=0;i<path1.size() && i<path2.size();i++){
			if(path1.get(i)!=path2.get(i)){
				break;
			}
		}
		if(i==0) return path1.get(0);
		return path1.get(i-1);
	}
	
	//function to store the path from root to key.
	private boolean getPath(Node root,int key,ArrayList<Node> path){
		if(root==null){
			return false;
		}
		path.add(root);
		if(root.data==key){
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
		path.remove(path.size()-1);
		return false;
	}
}
