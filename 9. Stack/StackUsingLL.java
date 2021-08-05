/* Implement a stack using singly linked list */

import java.util.*;
public class Main{
	public static void main(String[] args){
		//Solution obj = new Solution();
		MyStack obj = new MyStack();
		obj.push(20);
		obj.push(48);
		obj.push(34);
		obj.display();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.display();
		System.out.println(obj.isEmpty());
		obj.push(787);
		obj.push(232);
		obj.push(131);
		obj.push(132);
		System.out.println(obj.isEmpty());
		System.out.println("Top element: "+obj.peek());
		obj.display();
	}
}

class MyStack{
	
	private class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	private Node top = null;

	public boolean isEmpty(){
		return top==null;
	}

	public int peek(){
		if(top==null){
			System.out.println("Stack is empty");
			return -1;
		}
		return top.data;
	}
	
	public void push(int d){
		Node temp = new Node(d);
		temp.next = top;
		top = temp;
	}

	public int pop(){
		if(top==null){
			System.out.println("Stack underflow");
			return -1;
		}
		int el = top.data;
		top = top.next;
		return el;
	}
	
	public void display(){
		if(top==null){
			System.out.println("Stack is empty");
			return;
		}
		Node temp = top;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
