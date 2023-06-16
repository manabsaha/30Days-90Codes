/* Given an array Arr of size N, the array contains numbers in range from 0 to K-1 where K is a positive integer and K <= N. Find the maximum 
repeating number in this array. If there are two or more maximum repeating numbers return the element having least value. */

class Solution {
    int maxRepeating(int[] arr, int n, int k) {
        int count[] = new int[k];
        int max;
        for(int i=0;i<k;i++){
            count[i] = 0;
        }
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        max = 0;
        for(int i=1;i<k;i++){
            if(count[i]>count[max]){
                max = i;
            }
        }
        return max;
    }
}
