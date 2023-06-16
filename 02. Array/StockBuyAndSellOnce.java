/* Leetcode 121: You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future 
to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

public class Main{
	public static void main(String[] args){
		int arr[] = {5,6,7,16,1,9,10,18,20};
		Solution obj = new Solution();
		System.out.println(obj.maxProfit(arr, arr.length));
	}
}

class Solution{
	public int maxProfit(int arr[],int n){
		int min=arr[0];
		int mxprofit = 0;
		for(int i=1;i<n;i++){
			if(arr[i]<min){
				min = arr[i];
			}
			if(arr[i]-min>mxprofit){
				mxprofit = arr[i]-min;
			}
		}
		return mxprofit;
	}
}
