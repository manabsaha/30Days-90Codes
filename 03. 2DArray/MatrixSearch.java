// Search for an element in a matrix in which every rows and columns are sorted in ascending order.
// Time: O(n)
// Return true if present, else false.

public class Main{
	public static void main(String[] args){
		int arr[][] = {{5,6,7,13},{8,9,10,15},{14,16,18,20}};
		Solution obj = new Solution();
		System.out.println(obj.searchMatrix(arr, arr.length, arr[0].length, 10));
	}
}

class Solution{
	public boolean searchMatrix(int arr[][],int m,int n,int el){
		int i=0,j=n-1;
		while(i<m && j>=0){
			if(arr[i][j]==el){
				return true;
			}
			else if(el>arr[i][j]){
				i++;
			}
			else{
				j--;
			}
		}
		return false;
	}
}
