/* GOOGLE KICKSTART QUESTION
Isyana is given the number of visitors at her local theme park on N consecutive days. The number of visitors 
on the i-th day is Vᵢ . A day is record breaking if it satisfies both of the following conditions:

i) The number of visitors on the day is strictly larger than the number of visitors on each of the previous days.

ii) Either it is the last day, or the number of visitors on the day is strictly larger than the number of visitors 
on the following day.

Note that the very first day could be a record breaking day!

Please help Isyana find out the number of record breaking days.
*/

public class Main{
	public static void main(String[] args){
		int arr[] = {5,7,3,8,4,7,13,10};
		Solution obj = new Solution();
		System.out.print("Count: "+obj.recordBreakingDays(arr,arr.length));
	}
}

class Solution{
	public int recordBreakingDays(int arr[],int n){
		int count = 0;
		int max = arr[0];
		if(arr[0]>arr[1]) count++;
		for(int i=1;i<n-1;i++){
			if(arr[i]>max){
				max = arr[i];
				if(arr[i]>arr[i+1]){
					//arr[i] is the no of visitors in that record breaking day
					count++;
				}
			}
		}
		if(arr[n-1]>max) count++;
		return count;
	}	
}
