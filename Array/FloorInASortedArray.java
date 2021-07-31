/* Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K 
is smaller than or equal to x. Find the index of K(0-based indexing). 
Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is 2 (i.e K = 2), whose index is 1(0-based indexing). */

class Solution{
    static int findFloor(long arr[], int n, long x){
        if(x<arr[0]) return -1;
        int low = 0;
        int high = n-1;
        int mid;
        int lpos = -1;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]>x){
                high = mid-1;
            }
            else{
                lpos = mid;
                low = mid+1; 
            }
        }
        return lpos;
    }
}
