// 2D Matrix multiplication
// Time: O(n³)

public class Main{
	public static void main(String[] args){
		int arr1[][] = {{5,6,1,4},{12,5,3,7},{13,15,9,2}};
		int arr2[][] = {{5,6,7},{11,12,13},{8,9,10},{1,2,3}};
		Solution obj = new Solution();
		obj.multiplyMatrix(arr1, arr2, arr1.length, arr1[0].length, arr2.length, arr2[0].length);
	}
}

class Solution{
	public void multiplyMatrix(int arr1[][],int arr2[][],int m1,int m2,int n1,int n2){
		if(m2!=n1){
			System.out.println("Matrix multiplication not possible");
			return;
		}
		
		int ans[][] = new int[m1][n2];
		int sum=0;
		for(int i=0;i<m1;i++){
			for(int j=0;j<n2;j++){
				for(int k=0;k<m2;k++){
					sum+=(arr1[i][k]*arr2[k][j]);
				}
				ans[i][j] = sum;
				sum=0;
			}
		}
		
		//print matrix
		for(int i=0;i<m1;i++){
			for(int j=0;j<n2;j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}

