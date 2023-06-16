/* Find number of bits to change in b so that it becomes a. */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println(obj.bitsToChange(10,20));
	}
}

class Solution
{
	public int bitsToChange(int a,int b){
		int c = a^b;
		int count = 0;
		while(c!=0){
			count++;
			c = c&(c-1);
		}
		return count;
	}
}
