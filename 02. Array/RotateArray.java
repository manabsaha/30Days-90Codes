/* Given an unsorted array arr[] of size N, rotate it by D elements (clockwise). 
Eg. k = 3
arr = 2 4 6 8 10 12 14 16 18 20
output: 8 10 12 14 16 18 20 2 4 6
*/

public class Main{
	public static void main(String[] args){
		int arr[] = {3,5,6,8,12,15,22,40,46};
		Solution obj = new Solution();
    int k = 3;
		obj.rotateArray(arr,k);
	}
}

class Solution{
	public void rotateArray(int arr[],int k){
		int n = arr.length;
		int i=0,j=n-1;
		reverseArray(arr,i,j);
		i=0;
		j=n-k-1;
		reverseArray(arr,i,j);
		i=j+1;
		j=n-1;
		reverseArray(arr,i,j);
		for(i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	private void reverseArray(int arr[], int i,int j){
		while(i<j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
