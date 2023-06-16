// You are given an array arr and size n
//The task is to complete the insert() function which is used to implement Insertion Sort.

class Solution
{
  static void insert(int arr[],int i)
  {
       for(int j=i-1;j>=0;j--){
            if(arr[j]>arr[i]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i--;
            }
        }
  }
  //Function to sort the array using insertion sort algorithm.
  public void insertionSort(int arr[], int n)
  {
        for(int i=1;i<n;i++){
            insert(arr,i);
        }
  }
}
