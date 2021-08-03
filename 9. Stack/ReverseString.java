/*LEETCODE 151
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space 
separating the words. Do not include any extra spaces.
Input: this is a   good day in a while
Output: while a in day good a is this */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
        System.out.print(obj.reverseWords("this is a   good day in a while"));
	}
}

class myStack{
        private String[] data;
        private int size;
        private int top = -1;
        public myStack(int s){
            size = s;
            data = new String[size];
        }
        public int size(){ return top+1; }
        public boolean empty(){
            if(top==-1) return true;
            return false;
        }
        public String peek(){
            if(!empty()){
                return data[top];
            }
            return null;
        }
        public void push(String s){
            if(top==size-1){
                System.out.println("Stack Overflow");
                return;
            }
            data[top+1] = s;
            top++;
        }
        public void pop(){
            if(top==-1){
                System.out.println("Stack empty");
                return;
            }
            --top;
        }
}

class Solution {
    
    public String reverseWords(String s) {
        s += " ";
        myStack stk = new myStack(5001);
        int n = s.length();
        String str = "";
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=' ') str += s.charAt(i);
            else{
                stk.push(str);
                str = "";
            }
        }
        str = "";
        n = stk.size();
        for(int i=0;i<n;i++){
            if(stk.peek()!="") str = str + stk.peek() + " ";
            stk.pop();
        }
        return str.trim();
    }
}
