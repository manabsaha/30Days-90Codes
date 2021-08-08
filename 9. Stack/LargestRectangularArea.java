/* Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. 
For simplicity, assume that all bars have the same width and the width is 1 unit. 
Approach: Maintain left and right boundary of each heights in array using Stack 
Then (right-left-1) gives the width */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		long arr[] = {9,10,4,10,4,5,16};
		System.out.println(obj.getMaxArea(arr));
	}
}

class Solution
{
    public static long getMaxArea(long hist[]) {
    	int n = hist.length;
        long left[] = new long[n];
        long right[] = new long[n];
        
        //right boundary
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        right[n-1] = n;
        for(int i=n-2;i>=0;i--){
            while(!st.empty() && hist[st.peek()]>=hist[i]){
                st.pop();
            }
            if(st.empty()){
                right[i] = n;
            }
            else{
                right[i] = st.peek();
            }
            st.push(i);
        }       
        
        //left boundary
        st.clear();
        st.push(0);
        left[0] = -1;
        for(int i=1;i<n;i++){
            while(!st.empty() && hist[st.peek()]>=hist[i]){
                st.pop();
            }
            if(st.empty()){
                left[i] = -1;
            }
            else{
                left[i] = st.peek();
            }
            st.push(i);
        }   
        
        //calculate area
        long maxArea = 0,width,area;
        for(int i=0;i<n;i++){
            width = right[i] - left[i] - 1;
            area = hist[i] * width;
            if(area>maxArea) maxArea = area;
        }
        return maxArea;
    }
        
}
