/* Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. 
An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, “act” and “tac” 
are an anagram of each other */

class Solution
{    
    public static boolean isAnagram(String a,String b)
    {
        HashMap<Character,Integer> count = new HashMap<>();
        int m = a.length();
        int n = b.length();
        if(n!=m) return false;
        int c;
        for(int i=0;i<m;i++){
            if(count.containsKey(a.charAt(i))){
                c = count.get(a.charAt(i));
                count.put(a.charAt(i),++c);
            }
            else{
                count.put(a.charAt(i),1);
            }
        }
        for(int i=0;i<n;i++){
            if(count.containsKey(b.charAt(i))){
                c = count.get(b.charAt(i));
                --c;
                if(c==0){
                    count.remove(b.charAt(i));
                }
                else{
                    count.put(b.charAt(i),c);
                }
            }
        }
        if(count.isEmpty()){
            return true;
        }
        return false;
        
    }
}
