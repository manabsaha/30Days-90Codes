/* Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target node */

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
		root.left.left.left = new Node(110);
		root.left.left.right = new Node(120);
		root.right.left.left = new Node(150);
		root.right.left.right = new Node(160);
		Solution obj = new Solution();
		obj.printNodesAtK(root,root.left,2);
	}
}

class Solution{

	//print nodes at distance K from given root.
	void printSubtreeNodes(Node root,int k){
		if(root==null){
			return;
		}
		if(k==0){
			System.out.println(root.data);
			return;
		}
		printSubtreeNodes(root.left,k-1);
		printSubtreeNodes(root.right,k-1);
	}

	int printNodesAtK(Node root,Node target,int k){
		if(root==null){
			return -1;
		}

		//target at root
		if(root==target){
			printSubtreeNodes(root,k);
			return 0;
		}
		
		//from left of ancestor
		int left = printNodesAtK(root.left,target,k);
		if(left!=-1){
			if(left+1==k){
				System.out.println(root.data);
			}
			else{
				printSubtreeNodes(root.right,k-left-2);
			}
			return left+1;
		}
		
		//from right of ancestor
		int right = printNodesAtK(root.right,target,k);
		if(right!=-1){
			if(right+1==k){
				System.out.println(root.data);
			}
			else{
				printSubtreeNodes(root.left,k-right-2);
			}
			return right+1;
		}
		return 0;
	}
}
