/* Given an array arr of size n and an integer sum. 
Find if there's a triplet in the array which sums up to the given integer.
Eg. n = 6, X = 13
arr[] = [1 4 45 6 10 8]
True. The triplet {1, 4, 8} in the array sums up to 13. */

public class Main{
	public static void main(String[] args){
		int arr[] = {3,5,6,8,12,15,22,40,46};
		Solution obj = new Solution();
		System.out.println(obj.tripletSum(arr,35));
	}
}

class Solution{
	public boolean tripletSum(int arr[],int sum){
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0;i<n;i++){
			int rem = sum - arr[i];
			int j=i+1,k=n-1;
			while(j<k){
				if(arr[j]+arr[k]==rem){
					return true;
				}
				else if(arr[j]+arr[k]<rem){
					j++;
				}
				else{
					k--;
				}
			}
		}
		return false;
	}
}
