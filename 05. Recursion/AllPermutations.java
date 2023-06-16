// Given a string S. The task is to print all permutations of a given string.

import java.util.*;

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		List<String> res = obj.findPermutation("abc");
		for(String i:res) System.out.println(i);
	}
}

class Solution{
    private List<String> res = new ArrayList<>();

    public List<String> findPermutation(String S) {
        allPermutations(S,0,S.length()-1);
        Collections.sort(res);
        return res;
    }
	
	public void allPermutations(String s,int l,int r){
		if(l==r){
			res.add(s);
			return;
		}
		for(int i=l;i<=r;i++){
			s = swap(s,l,i);
			allPermutations(s,l+1,r);
			s = swap(s,l,i);
		}
	}

	private String swap(String s, int i, int j){
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
