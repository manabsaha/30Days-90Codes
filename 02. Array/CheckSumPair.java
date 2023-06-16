// Find a pair in the array with a given sum, if exists return true else false.
// APPROACH: Two pointer
// CONDITION: Array must be sorted, if not sort it first.

public class Main{
	public static void main(String[] args){
		int arr[] = {3,5,7,12,15,18};
		Solution obj = new Solution();
		System.out.print(obj.checkSumPair(arr,arr.length,12));
	}
}

class Solution{
	public boolean checkSumPair(int arr[],int n,int sum){
		int low=0,high=n-1;
		while(low<high){
			int s = arr[low]+arr[high];
			if(s==sum){
				return true;
			}
			else if(s<sum){
				low++;
			}
			else{
				high--;
			}
		}
		return false;
	}
}
