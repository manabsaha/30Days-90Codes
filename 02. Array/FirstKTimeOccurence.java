/*Given an array of N integers. Find the first element that occurs K number of times. 
Input :
N = 7, K = 2
A[] = {1, 7, 4, 3, 4, 8, 7}
Output : 4 
Time: O(N) Space: O(N) */

class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
        HashMap<Integer,Integer> keys = new HashMap<Integer,Integer>();
        if(k==1) return a[0];
        for(int i=0;i<n;i++){
            if(!keys.containsKey(a[i])){
                keys.put(a[i],1);
            }
            else{
                int count = keys.get(a[i])+1;
                if(count == k) return a[i];
                keys.put(a[i],count);
            }
        }
        return -1;
    } 
}
