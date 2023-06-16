//Check whether a string is Palindrome String or not. Return true if yes else false.

public class Main{
	public static void main(String[] args){
		int arr[] = {3,5,7,12,15,18};
		Solution obj = new Solution();
		System.out.println(obj.checkPalindrome("malayalam"));
		System.out.println(obj.checkPalindrome("racecar"));
		System.out.println(obj.checkPalindrome("wedding"));
	}
}

class Solution{
	public boolean checkPalindrome(String s){
		int n = s.length();
		for(int i=0;i<=n/2;i++){
			if(s.charAt(i)!=s.charAt(n-1-i)){
				return false;
			}
		}
		return true;
	}
}
