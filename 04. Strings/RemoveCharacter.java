/* Given two strings string1 and string2, remove those characters from first string(string1) which are present in second string(string2). 
Both the strings are different and contain only lowercase characters.
NOTE: Size of  first string is always greater than the size of  second string( |string1| > |string2|).
Input:
string1 = "occurrence"
string2 = "car"
Output: "ouene"
Time: O(|String1| + |String2|) Space: O(constant) */

class Solution{
    static String removeChars(String string1, String string2){
        // code here
        int n1 = string1.length();
        int n2 = string2.length();
        String str = "";
        HashSet<Character> k = new HashSet<>();
        for(int i=0;i<n2;i++){
            k.add(string2.charAt(i));
        }
        for(int i=0;i<n1;i++){
            if(!k.contains(string1.charAt(i))){
                str += string1.charAt(i);
            }
        }
        return str;
    }
}
