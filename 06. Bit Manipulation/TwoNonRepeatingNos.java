/* Given an array A containing N positive numbers, out of which N-2 numbers exist in pairs whereas the other two number occur exactly 
once and are distinct. Find the other two numbers. */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int arr[] = {1 ,2, 3 ,2, 1, 4};
		int nums[] = obj.nonRepeating(arr);
		for(int i=0;i<nums.length;i++) System.out.println(nums[i]);
	}
}

class Solution{
	public int[] nonRepeating(int[] arr){
		int n = arr.length;
		int nums[] = new int[2];
		int res = 0;
		for(int i=0;i<n;i++){
			res = res^arr[i];
		}
		int pos=0;
		int temp = 1;
		while((res&temp)==0){
			temp = temp<<1;
			pos++;
		}
		int r = res;
		for(int i=0;i<n;i++){
			if((arr[i]&temp)!=0){
				res = res^arr[i];
			}
		}
		r = r^res;
		if(res<r){
			nums[0] = res;
			nums[1] = r;
		}
		else{
			nums[0] = r;
			nums[1] = res;
		}
		return nums;
	}
}
