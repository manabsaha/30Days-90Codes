/* Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
Eg.  N = 5 
A[] = {1,2,3,5} 
Output: 4 in Time: O(n) 
Approach: Sum of first N natural numbers */

class Solution {
    int MissingNumber(int arr[], int n) {
        int arraySum = 0;
        for(int i=0;i<n-1;i++){
            arraySum += arr[i];
        }
        int totalSum = (n*(n+1))/2;
        return totalSum - arraySum;
    }
}
