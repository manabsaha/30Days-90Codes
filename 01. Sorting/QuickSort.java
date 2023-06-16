/* Quick Sort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
Given an array arr[], its starting position low and its ending position high.
Implement the partition() and quickSort() functions to sort the array.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)
*/
class Solution
{
    static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static void quickSort(int arr[], int low, int high)
    {
        if(low<high){
            int j = partition(arr,low,high);
            quickSort(arr,low,j-1);
            quickSort(arr,j+1,high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i=low-1,j;
        for(j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,high);
        return i;
    } 
}
