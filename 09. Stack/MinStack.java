/* Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional 
operation getMin() which should return minimum element from the SpecialStack in O(1) time. 
Your task is to complete all the functions, using stack data-Structure. */

class Solution{  
    private Stack<Integer> minStack = new Stack<>();
    int size = 0;
	
	public void push(int a,Stack<Integer> s){
	    s.push(a);
	    size++;
	    if(!minStack.empty()){
	        if(minStack.peek() > a){
	            minStack.push(a);
	        }
	        else{
	            minStack.push(minStack.peek());
	        }
	    }
	    else{
	        minStack.push(a);
	    }
	}
	
	public int pop(Stack<Integer> s){
            if(s.isEmpty()){
                return -1;
            }
            int el = s.peek();
            s.pop();
            size--;
            minStack.pop();
            return el;
	}
	
	public int min(Stack<Integer> s){
           return minStack.peek();
	}
	
	public boolean isFull(Stack<Integer>s, int n){
            return size==n;
	}
	
	public boolean isEmpty(Stack<Integer>s){
          return s.empty();
	}
}
