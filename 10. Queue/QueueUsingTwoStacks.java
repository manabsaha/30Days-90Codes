class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //enqueue O(n) time.
    void Push(int x)
    {
	   if(!s2.empty()){
	       while(!s2.empty()){
	           s1.push(s2.peek());
	           s2.pop();
	       }
	   }
	   s1.push(x);
    }
	
    //dequeue O(n) time.
    int Pop()
    {
       if(s1.empty() && s2.empty()) return -1;
	   if(!s1.empty()){
	        while(!s1.empty()){
	            s2.push(s1.peek());
	            s1.pop();
	        }   
	   }
	   int el = s2.peek();
	   s2.pop();
	   return el;
    }
}
