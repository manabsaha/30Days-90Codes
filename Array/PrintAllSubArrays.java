// Print all the subarrays of a given array.

public class Main{
	public static void main(String[] args){
		int arr[] = {5,7,3,8,4,7,13,10};
		Solution obj = new Solution();
		obj.printAllSubArrays(arr,arr.length);
	}
}

class Solution{
	public void printAllSubArrays(int arr[],int n){
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				for(int k=i;k<=j;k++){
					System.out.print(arr[k]+" ");
				}
				System.out.println();
			}
		}
	}
}

