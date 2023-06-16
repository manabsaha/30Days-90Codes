/* Given a string S, find the length of the longest substring without repeating characters.
Approach: Two pointer
Technique: Sliding window */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println("Max length: "+obj.longestSubstringWithoutRep("abcdhcbayr"));
	}
}

class Solution{
	public int longestSubstringWithoutRep(String s){
		int start = 0;
		int n = s.length();
		HashSet<Character> set = new HashSet<>();
		int maxLen = 0;
		int curr = 0;
		int end=0;
		while(end<n){
			if(!set.contains(s.charAt(end))){
				set.add(s.charAt(end));
			}
			else{
				do{
					set.remove(s.charAt(start));
					start++;
				}while(set.contains(s.charAt(end)));
				set.add(s.charAt(end));
			}
			curr=set.size();
			if(curr>maxLen){
				maxLen = curr;
			}
			end++;
		}
		System.out.println("Max substring: "+s.substring(start,start+maxLen));
		return maxLen;
	}
}

