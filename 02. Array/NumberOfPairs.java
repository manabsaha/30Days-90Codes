/*Question GFG:
Given two arrays X and Y of positive integers, find the number of pairs such that x^y > y^x (raised to power of) where x is an element 
from X and y is an element from Y.
Approach: Sort two arrays and find floor index of each value of x in y and handle the corners such as 0,1,2 and 3.
*/

class Solution
{
    
    // x[], y[]: input array elements
    // M, N: size of arrays x[] and y[] respectively
    //Function to count number of pairs such that x^y is greater than y^x.
    static long countPairs(int x[], int y[], int M, int N)
    {
        Arrays.sort(x);
        Arrays.sort(y);
        int zero=0,one=0,two=0,three=0,four=0;
        for(int i=0;i<N;i++){
            if(y[i]==0) zero++;
            else if(y[i]==1) one++;
            else if(y[i]==2) two++;
            else if(y[i]==3) three++;
            else if(y[i]==4) four++;
        }
        long count = 0;
        for(int i=0;i<M;i++){
            if(x[i]==0){
                continue;
            }
            else if(x[i]==1){
                count+=zero;
            }
            else if(x[i]==2){
                int idx = getFloor(y,N,2);
                if(idx!=-1)
                    count += N - idx;
                count += zero + one - three - four;
            }
            else{
                int idx = getFloor(y,N,x[i]);
                if(idx!=-1)
                    count += N - idx;
                count += zero + one;
                if(x[i]==3)
                    count += two;
            }
        }
        return count;
    }
    
    private static int getFloor(int[] arr,int n,int k){
        int low = 0;
        int high = n-1;
        int idx = -1;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]>k){
                idx = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return idx;
    }
}
