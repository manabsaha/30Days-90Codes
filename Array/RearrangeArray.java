/* Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, 
second should be min value, third should be second max, fourth should be second min and so on.
Input:
N = 6
arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
Explanation: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.
Technique: Two pointer & Modulo Arithmetic */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		obj.rearrange(arr,arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}

class Solution{
    public static void rearrange(int arr[], int n){  
        int j = n-1;
        int min = 0;
        int maxel = arr[n-1]+1;
        for(int i=0;i<n;i++){
        	if(i%2==0){
        		arr[i] = arr[i] + maxel*(arr[j]%maxel);
        		j--;
        	}
        	else{
        		arr[i] = arr[i] + maxel*(arr[min]%maxel);
        		min++;
        	}
        }
        for(int i=0;i<n;i++) arr[i] = arr[i]/maxel;
    }
}
