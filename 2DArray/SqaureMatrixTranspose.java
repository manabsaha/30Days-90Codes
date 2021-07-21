// Transpose of a square matrix
// By swapping arr[i][j] with arr[j][i] in the upper diagonal.

public class Main{
	public static void main(String[] args){
		int arr[][] = {{3,5,7},{12,15,18},{11,6,8}};
		Solution obj = new Solution();
		obj.transposeSquareMatrix(arr,arr.length);
	}
}

class Solution{
	public void transposeSquareMatrix(int arr[][], int n){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		//print the matrix
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
