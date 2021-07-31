/* Given a singly linked list of N nodes. The task is to find the middle of the linked list. For example, if given linked list is 1->2->3->4->5 
then the output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, if given linked list is 
1->2->3->4->5->6 then the output should be 4. */

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}

public class Main{
	
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of nodes: ");
    	int n = sc.nextInt();
    	System.out.println("Enter the nodes: ");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for(int i=0; i<n-1; i++)
        {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        Solution g = new Solution();
        int ans = g.getMiddle(head);
        System.out.println(ans);
        // printList(head);
    } 
} 

class Solution{
    int getMiddle(Node head){
         Node second = head;
         while((second.next != null) && (second.next.next != null)){
             head = head.next;
             second = second.next.next;
         }
         if(second.next != null) return head.next.data;
         return head.data;
    }
}
