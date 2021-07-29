/* The hiring team aims to find 3 candidates who are great collectively. Each candidate has his or her ability expressed as an integer. 
3 candidates are great collectively if product of their abilities is maximum. Given abilities of N candidates in an array arr[], find the maximum collective 
ability from the given pool of candidates. 
Approach: Maximum of (Product of maximum three elements AND the product of maximum element and minimum two elements) */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int arr[] = {65,-4,7,12,55,3,-6,0,34};
		System.out.println(obj.maxTripletProduct(arr));
	}
}

class Solution {
    long maxProduct(int[] arr, int n) {
        if(n<3) return  -1;
        int fmax=Integer.MIN_VALUE,smax=Integer.MIN_VALUE,tmax=Integer.MIN_VALUE;
		int fmin=Integer.MAX_VALUE,smin=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(arr[i]>fmax){
				tmax = smax;
				smax = fmax;
				fmax= arr[i];
			}
			else if(arr[i]>smax){
				tmax = smax;
				smax = arr[i];
			}
			else if(arr[i]>tmax){
				tmax = arr[i];
			}
			if(arr[i]<fmin){
				smin = fmin;
				fmin = arr[i];
			}
			else if(arr[i]<smin){
				smin = arr[i];
			}
		}
		return Math.max((long)fmax*(long)smax*(long)tmax,
		        (long)fmax*(long)fmin*(long)smin);
    }
}
