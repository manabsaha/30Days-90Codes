import java.util.*;
public class Main{
	public static void main(String[] args){
		MyQueue obj = new MyQueue();
		obj.insert(24);
		obj.insert(75);
		obj.insert(35);
		obj.display();
		obj.remove();
		obj.insert(122);
		obj.display();
		obj.remove();
		obj.remove();
		obj.remove();
		obj.display();
		obj.insert(70);
		obj.insert(80);
		obj.insert(90);
		obj.display();
		System.out.println(obj.isEmpty());
		System.out.println("Front: "+obj.getFront());
		System.out.println("Rear: "+obj.getRear());
	}
}

class MyQueue{

	private class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}

	private Node head = null;
	private Node tail = null;

	public boolean isEmpty(){
		return head==null;
	}

	public int getFront(){
		if(head!=null){
			return head.data;
		}
		return -1;
	}

	public int getRear(){
		if(tail!=null){
			return tail.data;
		}
		return -1;
	}

	public void insert(int d){
		Node temp = new Node(d);
		if(head!=null){
			tail.next = temp;
			tail = temp;
		}
		else{
			head = temp;
			tail = temp;
		}
	}

	public int remove(){
		if(head==null){
			System.out.println("Queue is empty");
			return -1;
		}
		int el = head.data;
		if(head!=tail){
			head = head.next;
		}
		else{
			head = null;
			tail = null;
		}
		return el;
	}

	public void display(){
		if(head==null){
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Your queue:");
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}
