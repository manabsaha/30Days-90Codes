// Find whether an element is present in a sorted array of infinite numbers
// You are not allow to use the length of the array.

public class Main{
	public static void main(String[] args){
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		Solution obj = new Solution();
		System.out.println(obj.searchInfiniteSortedArray(arr,9));
	}
}

class Solution{

	public boolean searchInfiniteSortedArray(int arr[],int el){
		int low = 0;
		int high = 1;
		while(arr[high]<=el){
			low = high;
			high = high*2;
		}
		return binarySearch(arr,low,high,el);
	}

	private boolean binarySearch(int arr[], int start, int end,int el){
		while(start<end){
			int mid = (start+end)/2;
			if(arr[mid]==el){
				return true;
			}
			else if(el>arr[mid]){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return false;
	}
}
