/* Max Heap using Array 
Insert and delete elements to and from the heap.
The root is always greater than its child.
Insert: O(logN)
Delete: O(logN) */

import java.util.*;
public class Main{
	public static void main(String[] args){
        Heap h = new Heap(1000);
        h.insert(40);
        h.insert(7);
        h.insert(3);
        h.insert(50);
        h.insert(2);
        h.insert(4);
        h.insert(5);
        h.insert(12);
        h.display();
        System.out.println("Removed "+h.remove());
        System.out.println("Removed "+h.remove());
        System.out.println("Removed "+h.remove());
        h.display();
	}
}

class Heap{
    int[] heap;
    int size;
    int curr = 0;
    
    //constructor
    Heap(int size){
        this.size = size;
        this.heap = new int[size+1];
    }

    //insert into heap in logN time.
    public void insert(int v){
        curr++;
        if(curr>size){
            System.out.println("Heap size full");
            curr--;
            return;
        }
        heap[curr] = v;
        int i = curr;
        int parent = i/2;
        while(parent>0){
            if(heap[parent]<heap[i]){
                int temp = heap[i];
                heap[i] = heap[parent];
                heap[parent] = temp;
                i = parent;
                parent = i/2;
            }
            else{
                return;
            }
        }
    }

    //remove from heap in logN time.
    public int remove(){
        if(curr<1){
            System.out.println("Heap is empty");
            return -1;
        }
        int el = heap[1];
        heap[1] = heap[curr];
        curr--;
        int i=1;
        int child;
        while(i<curr){
            if(2*i>curr && 2*i+1>curr){
                break;
            }
            else if(2*i<=curr && 2*i+1<=curr){
                int left = heap[2*i];
                int right = heap[2*i+1];
                child = left>right ? 2*i : 2*i+1;
            }
            else if(2*i<=curr){
                child = 2*i;
            }
            else{
                child = 2*i+1;
            }
            if(heap[i]<heap[child]){
                int temp = heap[child];
                heap[child] = heap[i];
                heap[i] = temp;
                i=child;
            }
            else{
                break;
            }
        }
        return el;
    }

    //display heap array.
    public void display(){
        if(curr<1){
            System.out.println("Heap is empty");
            return;
        }
        for(int i=1;i<=this.curr;i++)
            System.out.println(heap[i]);
    }
}
