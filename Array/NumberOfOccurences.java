/* Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr. 
Time: O(logN) Space: O(1) 
Approach: Binary Search -> find left index and find right index */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
    int arr[] = {1,4,5,5,5,6,7,7,12,14};
    int el = 5;
    System.out.println(obj.count(arr,arr.length,el));
	}
}

class Solution {
    
    int count(int[] arr, int n, int x) {
        // code here
        int l = firstBinarySearch(arr,0,n-1,x);
        int r = secondBinarySearch(arr,0,n-1,x);
        if(l==-1) return 0;
        return r-l+1;
    }
    
    private int firstBinarySearch(int[] arr,int low,int high,int el){
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if((mid==0 && arr[mid]==el) || (arr[mid]==el  && arr[mid-1]!=el)){
                return mid;
            }
            else if(arr[mid]>=el){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    private int secondBinarySearch(int[] arr,int low,int high,int el){
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if((mid==arr.length-1 && arr[mid]==el) || (arr[mid]==el  && arr[mid+1]!=el)){
                return mid;
            }
            else if(arr[mid]<=el){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
