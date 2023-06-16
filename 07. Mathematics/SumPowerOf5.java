/* Given an integer n, return 'true' if it is possible to represent n as the sum of distinct powers of five. 
Otherwise, return 'false'. */

import java.util.*;
public class Main{
	public static void main(String[] args){
		System.out.println("Enter a number:");
 		Scanner sc = new Scanner(System.in);
 		int num = sc.nextInt();
 		System.out.println(checkPowerSum(num));
	}

	private static boolean checkPowerSum(int n){
		int m = n;
		int a = (int)(Math.log(n)/Math.log(5));
		for(int i=a;i>=0;i--){
			int pow = (int)Math.pow(5,i);
			if(pow<=n){
				n -= pow;
			}
			if(n==0){
				return true;
			}
		}
		return false;		
	}
}
