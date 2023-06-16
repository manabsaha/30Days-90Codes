/* Given a string without spaces, the task is to remove duplicates from it.
Note: The original order of characters must be kept the same.
Time: O(N) Space: O(constant) */

class Solution {
    String removeDups(String S) {
        // code here
        int n = S.length();
        HashSet<Character> count = new HashSet<>();
        String str = "";
        for(int i=0;i<n;i++){
            if(count.contains(S.charAt(i))==false){
                count.add(S.charAt(i));
                str += S.charAt(i);
            }
        }
        return str;
    }
}
