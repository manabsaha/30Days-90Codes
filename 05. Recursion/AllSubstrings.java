/* Given a string S find all possible substrings of the string in lexicographically-sorted order.
Eg: "abc" -> a ab abc ac b bc c
* This can also be implemented using Binary Numbers.
*/

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		obj.AllPossibleStrings("abc");
	}
}

class Solution
{
    public void powerset(String s,int i,String curr,List<String> a){
		if(i==s.length()){
			if(s!="") a.add(curr);
			return;
		}
		powerset(s,i+1,curr+s.charAt(i),a);
		powerset(s,i+1,curr,a);
	}
    
    public List<String> AllPossibleStrings(String s)
    {
        List<String> a = new ArrayList<>(8);
        powerset(s,0,"",a);
        Collections.sort(a);
        for(String str : a){
        	System.out.println(str);
        }
        return a;
    }
}
