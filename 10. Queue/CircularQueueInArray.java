import java.util.*;
public class Main{
	public static void main(String[] args){
		int max = 5;
		MyQueue obj = new MyQueue(max);
		obj.display();
		obj.insert(240);
		obj.insert(2343);
		obj.insert(4567);
		obj.insert(878);
		obj.display();
		obj.remove();
		obj.remove();
		obj.insert(254);
		obj.insert(74);
		obj.insert(67);
		obj.display();
	}
}

class MyQueue{
	int queue[];
	int front = -1;
	int rear = -1;
	int max;

	MyQueue(int n){
		max = n;
		queue = new int[n];
	}
	
	public void insert(int x){
		if((front==0 && rear==max-1) ||(rear+1==front)){
			System.out.println("Queue full");
			return;
		}
		if(rear==-1){
			front = 0;
			rear = 0;
		}
		else if(rear==max-1){
			rear = 0;
		}
		else{
			rear++;
		}
		queue[rear] = x;
	}

	public void remove(){
		if(front == -1){
			System.out.println("Queue empty");
			return;
		}
		if(front==rear){
			front = -1;
			rear = -1;
		}
		else if(front==max-1){
			front = 0;
		}
		else{
			front++;
		}
	}

	public void display(){
		if(front==-1) return;
		System.out.println("Your queue:");
		if(front>rear){
			for(int i=front;i<max;i++){
				System.out.println(queue[i]);
			}
			for(int i=0;i<=rear;i++){
				System.out.println(queue[i]);
			}
		}
		else{
			for(int i=front;i<=rear;i++){
				System.out.println(queue[i]);
			}
		}
	}
}
