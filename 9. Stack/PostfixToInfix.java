/* Convert a given postfix expression to a infix expression.
Eg. ab*c+ 
((a*b)+c)
*/

import java.util.*;
public class MyClass{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println(obj.postfixToInfix("ab*c+"));
	}
}

class Solution{
	public String postfixToInfix(String exp){
		int n = exp.length();
		Stack<String> st = new Stack<>();
		char c;
		for(int i=0;i<n;i++){
			c = exp.charAt(i);
			if((c>='a' && c<='z') || (c>='A' && c<='Z')){
				st.push(c+"");
			}
			else{
				String a = st.peek();
				st.pop();
				String b = st.peek();
				st.pop();
				st.push("("+b+c+a+")");
			}
		}
		return st.peek();
	}
}
