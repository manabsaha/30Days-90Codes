/* LEETCODE 62: The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can either 
move only to right or down. 
Approach: Iterative (Dynamic Programming) */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println(obj.numberOfPaths(4.5));
	}
}

class Solution
{
    long numberOfPaths(int m, int n)
    {
        long col[] = new long[n];
        for(int i=0;i<n;i++) col[i] = 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                col[j] = col[j] + col[j-1];
            }
        }
        return col[n-1];
    }
}
