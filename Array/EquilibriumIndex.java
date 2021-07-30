/* Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array. 
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it. 
Here, 7th position is the equilibrium position => 2+2+4+5+8+9 = 30 and 16+14 = 30. 
Time: O(n) Space: O(1) */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int arr[] = {2,2,4,5,8,9,10,16,14};
        System.out.print(obj.equilibriumPoint(arr));
	}
}

class Solution{
	public int equilibriumPoint(int arr[]){
		int n = arr.length;
		if(n==1) return 1;
		if(n<3) return -1;
		int rightsum = 0;
		int leftsum = arr[0];
		for(int i=2;i<n;i++) rightsum += arr[i];
		for(int i=1;i<n-1;i++){
			if(leftsum==rightsum){
				return i+1;
			}
			else{
				leftsum += arr[i];
				rightsum -= arr[i+1];
			}
		}
		return -1;
	}
}
