// You are given an array arr and length n.
// The task is to complete the insert() function which is used to implement Insertion Sort.

class Solution
{
	int  select(int arr[], int i)
	{
        int min = i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[min]){
                min = j;
            }
        }
        return min;
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i=0;i<n;i++){
	        int min = select(arr,i);
	        int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
	    }
	}
}
