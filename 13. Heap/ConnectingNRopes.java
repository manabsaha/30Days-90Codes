/* There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal 
to sum of their lengths. The task is to connect the ropes with minimum cost. 
Eg. 
Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output: 
62 
Explanation:
First, connect ropes 4 and 2, which makes the array {6,7,6,9}. Next, add ropes 6 and 6, which results in {12,7,9}. Then, add 7
and 9, which makes the array {12,16}. And finally add these two which gives {28}. Hence, the total cost is 6 + 12 + 16 + 28 = 62.
*/

import java.util.*;
public class Main{
	public static void main(String[] args){
        long[] arr = {4, 2, 7, 6, 9};
        Solution obj = new Solution();
        System.out.println(obj.minCost(arr,arr.length));
	}
}

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        long cost = 0;
        while(pq.size()>1){
            long first = pq.poll();
            long second = pq.poll();
            long sum = first+second;
            cost += sum;
            pq.add(sum);
        }
        return cost;
    }
}
