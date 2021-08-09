/* Traversals: INORDER, PREORDER & POSTORDER */

import java.util.*;
class Node{
		int data;
		Node left;
		Node right;
		public Node(int x){
			this.data = x;
			this.left = null;
			this.right = null;
		}
	}

public class Tree{	
	public static void main(String[] args){
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(60);
		root.left.right = new Node(40);
		root.right.left = new Node(70);
		root.right.right = new Node(50);
		
		//Traversals
		Solution obj = new Solution();
		
		System.out.print("In order: ");
		ArrayList<Integer> tr = obj.inorderTraversal(root);
		for(Integer i : tr) System.out.print(i+" ");
		
		System.out.print("\nPre order: ");
		tr = obj.preorderTraversal(root);
		for(Integer i : tr) System.out.print(i+" ");
		
		System.out.print("\nPost order: ");
		tr = obj.postorderTraversal(root);
		for(Integer i : tr) System.out.print(i+" ");
	}
}

class Solution
{
    private static ArrayList<Integer> inorder = new ArrayList<>();
    private static ArrayList<Integer> preorder = new ArrayList<>();
    private static ArrayList<Integer> postorder = new ArrayList<>();

    public static ArrayList<Integer> inorderTraversal(Node root){
        if(root == null) return inorder;
        inorderTraversal(root.left);
        inorder.add(root.data);
        inorderTraversal(root.right);
        return inorder;
    }

    public static ArrayList<Integer> preorderTraversal(Node root){
        if(root == null) return preorder;
        preorder.add(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return preorder;
    }

    public static ArrayList<Integer> postorderTraversal(Node root){
        if(root == null) return postorder;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        postorder.add(root.data);
        return postorder;
    }
}
