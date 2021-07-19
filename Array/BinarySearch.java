// Given a sorted array of size N and an integer K. Check if K is present in the array and return the position and return -1 if not present.

class Solution{
    static int searchInSorted(int arr[], int N, int K)
    {
       int low=0,high=N-1;
       int mid;
       while(low<=high){
           mid = (low+high)/2;
           if(arr[mid]==K){
               return mid;
           }
           else if(arr[mid]>K){
               high = mid-1;
           }
           else{
               low = mid+1;
           }
       }
       return -1;
    }
}
