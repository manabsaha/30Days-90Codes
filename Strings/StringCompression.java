/* LEETCODE 443: Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length. */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		char arr[] = {'a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c'};
		System.out.println(obj.compress(arr));
	}
}

class Solution {
    public int compress(char[] chars) {
        List<Character> compressed = new ArrayList<>();
        char c = chars[0];
        int count = 1;
        String s;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==c) count++;
            else{
                compressed.add(c);
                if(count>1){
                	s = String.valueOf(count);
                	for(int j=0;j<s.length();j++){
                		compressed.add(s.charAt(j));
                	}
                }
                c = chars[i];
                count = 1;
            }
        }
        compressed.add(c);
        if(count>1){
        	s = String.valueOf(count);
        	for(int j=0;j<s.length();j++){
        		compressed.add(s.charAt(j));
        	}
        }
        //for(char i:compressed) System.out.println(i);
        for(int i=0;i<compressed.size();i++) chars[i] = compressed.get(i);
        return compressed.size();
    }
}
