/* Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the 
inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j. */

class Solution
{
    static long count=0;
    public static long inversionCount(long arr[], long N)
    {
        int ub = (int)N;
        mergeSort(arr,0,ub-1);
        return count;
    }
    
    private static void mergeSort(long[] arr,int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);   
            merge(arr,l,mid,r);
        }
    }
    
    private static void merge(long arr[], int l, int mid, int r)
    {
        int n1 = mid-l+1;
        int n2 = r-mid;
        long a[] = new long[n1];
        long b[] = new long[n2];

        for(int i=0;i<n1;i++){
          a[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
          b[i] = arr[mid+1+i];
        }
        
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
          if(a[i]<=b[j]){
            arr[k] = a[i];
            k++;
            i++;
          }
          else{
            count += n1-i;
            arr[k] = b[j];
            k++;
            j++;
          }
        }
        while(i<n1){
          arr[k] = a[i];
          k++;
          i++;
        }
        while(j<n2){
          arr[k] = b[j];
          k++;
          j++;
        }
    }
}
