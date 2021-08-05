/* Given an infix expression in the form of string str. Convert this infix expression to postfix expression 
Eg. 
Input: str = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
*/

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
    System.out.println(obj.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
	}
}

class Solution
{
	public static String infixToPostfix(String exp) 
	{
		String res = "";
		Stack<Character> st = new Stack<>();
        int n = exp.length();
        char c;
		for(int i=0;i<n;i++){
		    c = exp.charAt(i);
		    if((c>='a' && c<='z')||(c>='A' && c<='Z')){
		        res += c;
		    }
		    else if(c=='('){
		        st.push(c);
		    }
		    else if(c==')'){
		        while(!st.empty() && st.peek()!='('){
		            res += st.peek();
		            st.pop();
		        }
		        st.pop();
		    }
		    else{
		        while(!st.empty() && precedence(st.peek())>=precedence(c)){
		            res += st.peek();
		            st.pop();
		        }
		        st.push(c);
		    }
		}
		while(!st.empty()){
		    res += st.peek();
		    st.pop();
		}
		return res;
	} 
	
	private static int precedence(char c){
		    if(c=='^') return 3;
		    if(c=='/' || c=='*' || c=='%') return 2;
		    if(c=='+' || c=='-') return 1;
		    else return -1;
		}
}
