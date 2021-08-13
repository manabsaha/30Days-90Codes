/*K-th largest element in an array
Approach: Using max heap. */

import java.util.*;
public class Main{
	public static void main(String[] args){
        int[] arr = {13,45,8,2,0,23,7,15};
        Solution obj = new Solution();
        int k = 3;
        System.out.println(obj.kthLargest(arr,arr.length,k));
	}
}

class Solution{
    
    //max heap implementation
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        int[] heap = new int[k];
        for(int i=0;i<k;i++){
            insert(heap,arr[i],i);
        }
        for(int i=k;i<=r;i++){
            if(arr[i]<heap[0]){
                remove(heap);
                insert(heap,arr[i],k-1);
            }
        }
        return heap[0];
    }
    
    private static void insert(int[] heap,int el,int i){
        heap[i] = el;
        int parent = (i+1)/2-1;
        while(parent>=0){
            if(heap[parent]<heap[i]){
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;
                i = parent;
                parent = (i+1)/2-1;
            }
            else{
                break;
            }
        }
    }
    
    public static void remove(int[] heap){
        int k = heap.length;
        heap[0] = heap[k-1];
        int i = 0;
        while(i<k-1){
            int left = 2*i+1;
            int right = 2*i+2;
            int largest;
            if(left<k && right<k){
                largest = heap[left]>heap[right] ? left:right;
            }
            else if(left<k){
                largest = left;
            }
            else if(right<k){
                largest = right;
            }
            else{
                break;
            }
            if(heap[i]<heap[largest]){
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                i = largest;
            }
            else{
                break;
            }
        }
    }
}
