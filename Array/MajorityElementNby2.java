
/* Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears 
more than (N/2) times in the array.
ALGORITM: Boyre Moore's Voting Algorithm.
*/
public class Main{
	public static void main(String[] args){
		int arr[] = {3,4,3,4,3};
		Solution obj = new Solution();
		System.out.print(obj.majorityElement(arr));
	}
}

class Solution{
	public int majorityElement(int arr[]){
		int n = arr.length;
		int count =1;
		int ansIdx = 0;
		for(int i=1;i<n;i++){
			if(arr[i]==arr[ansIdx]){
				count++;
			}
			else{
				count--;
			}
			if(count==0){
				ansIdx=i;
				count=1;
			}
		}
		int max = 0;
		if(count>0){
			for(int i=0;i<n;i++){
				if(arr[i]==arr[ansIdx]){
					max++;
				}
			}
			if(max>(n/2)){
				return arr[ansIdx];
			}
		}
		return -1;
	}
}
