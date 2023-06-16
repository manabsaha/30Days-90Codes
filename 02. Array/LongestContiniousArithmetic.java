/* GOOGLE KICKSTART PROBLEM
An arithmetic array is an array that contains at least two integers and the differences between consecutive 
integers are equal. For example, [9, 10], [3, 3, 3], and [9, 7, 5, 3] are arithmetic arrays, while [1, 3, 3, 7], 
[2, 1, 2], and [1, 2, 4] are not arithmetic arrays.

Sarasvati has an array of N non-negative integers. The i-th integer of the array is Aᵢ. She wants to choose 
a contiguous arithmetic subarray from her array that has the maximum length. Please help her to determine the 
length of the longest contiguous arithmetic subarray.
*/

public class Main{
	public static void main(String[] args){
		int arr[] = {1,4,8,13,17,21,25,29,32};
		Solution obj = new Solution();
		System.out.print("Length: "+obj.longestContinuousArithmetic(arr,arr.length));
	}
}

class Solution{
	public int longestContinuousArithmetic(int arr[],int n){
		int prev_diff = arr[1] - arr[0];
		int max=1,current=1;
		for(int i=2;i<n;i++){
			if(arr[i]-arr[i-1]==prev_diff){
				current++;
			}
			else{
				prev_diff = arr[i]-arr[i-1];
				current = 1;
			}
			if(max<current){
				max = current+1;
			}
		}
		return max;
	}
}
