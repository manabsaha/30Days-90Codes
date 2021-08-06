/* Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. 
Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements. 
Technique: Gap Algorithm 
Another way: Insertion Sort Approach */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		long arr1[] = {1, 3, 5, 7};
		long arr2[] = {0, 2, 6, 8, 9};
		obj.merge(arr1,arr2,arr1.length,arr2.length);
		for(int i=0;i<arr1.length;i++) System.out.print(arr1[i]+" ");
		for(int i=0;i<arr2.length;i++) System.out.print(arr2[i]+" ");
	}
}

class Solution
{
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        double gap = (n+m)/2.0;
        int i,j;
        long temp;
        while(gap>=1){
            i = 0;
            j = (int) Math.ceil(gap);
            gap = j;
            while(j<n+m){
                if(i>=n && j>=n){
                    if(arr2[i-n]>arr2[j-n]){
                        temp = arr2[i-n];
                        arr2[i-n] = arr2[j-n];
                        arr2[j-n] = temp;
                    }
                }
                else if(j>=n){
                    if(arr1[i]>arr2[j-n]){
                        temp = arr1[i];
                        arr1[i] = arr2[j-n];
                        arr2[j-n] = temp;
                    }
                }
                else{
                    if(arr1[i]>arr1[j]){
                        temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                }
                i++;
                j++;
            }
            gap = gap/2.0;;
        }
    }
}
