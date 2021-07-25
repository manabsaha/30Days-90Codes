/* For an integer N find the number of trailing zeroes in N!.
Eg. 5! = 120 => 1 zero */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println(obj.trailingZeroes(100));
	}
}

class Solution{
	public int trailingZeroes(int n){
		int count = 0;
		for(int i=5;i<=n;i*=5){
			count += n/i;
		}
		return count;
	}
}
