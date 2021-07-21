/* Leetcode 122: You are given an array arr where arr[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). 

Approach: Buy at local minima and sell at local maxima.
*/

public class Main{
	public static void main(String[] args){
		int arr[] = {5,6,7,16,1,9,10,18,20};
		Solution obj = new Solution();
		System.out.println(obj.maxProfit(arr, arr.length));
	}
}

class Solution{
	public int maxProfit(int arr[],int n){
		int mxprofit = 0;
		for(int i=1;i<n;i++){
			if(arr[i]>arr[i-1]){
				mxprofit += arr[i] - arr[i-1];
			}
		}
		return mxprofit;
	}
}
