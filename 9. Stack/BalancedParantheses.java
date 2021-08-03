/* Check balanced parantheses
Input: {([])}
Output: true
Explanation: { ( [ ] ) }. Same colored brackets can form balaced pairs, with 0 number of unbalanced bracket. */

class Solution
{
    static boolean ispar(String s)
    {
        Stack<Character> brackets = new Stack<>();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c=='{' || c=='[' || c=='('){
                brackets.push(c);
            }
            else{
                if(brackets.empty() == true){
                    return false;
                }
                else if(c==']' && brackets.peek()=='['){
                    brackets.pop();
                }
                else if(c=='}' && brackets.peek()=='{'){
                    brackets.pop();
                }
                else if(c==')' && brackets.peek()=='('){
                    brackets.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(brackets.empty() == true) return true;
        return false;
    }
}
