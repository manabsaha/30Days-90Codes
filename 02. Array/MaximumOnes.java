/* Leetcode 1004: Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array 
if you can flip at most k 0's.
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
*/

public class Main{
	public static void main(String[] args){
		int arr[] = {{1,0,0,1,0,0,1,1,0,1};}
		Solution obj = new Solution();
		System.out.println(obj.maxOnes(arr,arr.length,2));
	}
}

class Solution{
	public int maxOnes(int arr[],int n,int k){
		int count = 0;
		int start = 0,end,max=0;
		for(int i=0;i<n;i++){
			if(arr[i]==0){
				count++;
			}
			end = i;
			if(count>k){
				do{
					if(arr[start]==0){
						count--;
					}
					start++;
				}while(count>k);
			}
			if(end-start+1>max){
				max = end-start+1;
			}
		}
		return max;
	}
}
