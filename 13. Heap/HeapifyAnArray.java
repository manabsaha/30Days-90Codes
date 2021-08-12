/* Given an array of N elements. The task is to build a Binary Heap from the given array. The heap can be either Max Heap or Min Heap. 
This is the code for Max Heap. */

import java.util.*;
public class Main{
	public static void main(String[] args){
        int[] arr = {13,45,8,2,0,23,7,15};
        Solution obj = new Solution();
        obj.buildHeap(arr);
        for(int i=1;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
	}
}

class Solution{
    
    //function to build heap from an array.
    void buildHeap(int[] arr){
        int size = arr.length;
        for(int i=size/2;i>=0;i--){
            heapify(arr,i,size);
        }
    }

    //function to max heapify an array
    public void heapify(int[] heap,int i,int n){
        int largest = i;
        int lchild = 2*i+1;
        int rchild = 2*i+2;
        
        //if left child exists
        if(lchild<n && heap[lchild]>heap[largest]){
            largest = lchild;
        }
        
        //if right child exists
        if(rchild<n && heap[rchild]>heap[largest]){
            largest = lchild;
        }
        
        //if heap[i] is not max
        if(largest!=i){
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            //heapify again the subtree
            heapify(heap,largest,n);
        }
    }
}
