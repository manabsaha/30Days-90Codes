import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		obj.towerOfHanoi(3,1,2,3);
	}
}

class Solution{
	public void towerOfHanoi(int n,int a,int b,int c){
		if(n>0){
			towerOfHanoi(n-1,a,c,b);
			System.out.println("Move disc from rod "+a+" to rod "+c);
			towerOfHanoi(n-1,b,a,c);
		}
	}
}
