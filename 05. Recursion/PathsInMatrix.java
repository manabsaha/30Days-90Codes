/* The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can 
either move only to right or down.
Iterative approach can be: T[i][j] = T[i-1][j] + T[i][j-1]
This is implemented here using recursive approach.
*/

public class Main{
	public static void main(String[] args){
		int m = 4;
    int n = 5;
		Solution obj = new Solution();
		System.out.println(obj.numberOfPaths(m,n));
	}
}

class Solution
{
    public long numberOfPaths(int m, int n)
    {
        // code here
        if(m==1 || n==1){
            return 1;
        }
        return numberOfPaths(m-1,n)+numberOfPaths(m,n-1);
    }
}
