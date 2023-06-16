/* Find all non-empty subsets of a given string. Total : (2ⁿ - 1)
Technique: Using bit positions */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int n = 4;
		List<String> substrings = obj.allSubstrings("abc");
		for(String i:substrings) System.out.println(i);
	}
}

class Solution{
	public List<String> allSubstrings(String s){
		List<String> subs = new ArrayList<>();
		int n = s.length();
		int N = (int)Math.pow(2,n)-1;
		for(int i=0;i<=N;i++){
			int j=i;
			int k=2;
			String str = "";
			while(k>=0){
				if((j&1)==1) str = s.charAt(k) + str;
				j = j>>1;
				k--;
			}
			subs.add(str);
		}
		Collections.sort(subs);
		subs.remove(0);
		return subs;
	}
}
