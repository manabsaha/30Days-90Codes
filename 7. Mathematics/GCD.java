/* Find GCD of two number using modulo arithmetic */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int a = 12, b = 30;
		System.out.println(obj.gcd(a,b));
	}
}

class Solution {
   	public int gcd(int a,int b){
   		if(a==0) return b;
   		return gcd(b%a,a);
   	}
}
