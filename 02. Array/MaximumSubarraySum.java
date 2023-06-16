// Find the maximum subarray sum of a given array.
// KADANE'S ALGORITHM IS USED TO SOLVE THE QUESTION
// Here, maximum sum is 7+13 = 20

public class Main{
	public static void main(String[] args){
		int arr[] = {5,7,-3,-8,-4,7,13,-10};
		Solution obj = new Solution();
		System.out.print(obj.KadanesSum(arr,arr.length));
	}
}

class Solution{
	public int KadanesSum(int arr[],int n){
		int sum = 0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			sum += arr[i];
			if(sum>max){
				max = sum;
			}
			if(sum<0){
				sum = 0;
			}
		}
		return max;
	}
}
