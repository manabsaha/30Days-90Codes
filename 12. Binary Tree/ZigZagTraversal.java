/* Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.
Approach: Do a level order traversal using a queue. Store the odd level to arraylist directly. 
For even levels, maintain a stack for storing the values and after level is traversed pop them and add to result. */

class Solution
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> res = new ArrayList<>();
	    Queue<Node> q = new LinkedList<>();
	    Stack<Node> rev = new Stack<>();
        q.add(root);
        q.add(null);
        int leftToRight = 1;
        while(q.size()>1){
            Node curr = q.poll();
            if(curr==null){
                q.add(null);
                if(leftToRight==1){
	                leftToRight = 0;
	            }
	            else{
	                while(!rev.isEmpty()){
	                    res.add(rev.pop().data);
	                }
	                leftToRight = 1;
	            }
            }
            else{
                if(leftToRight==1){
	                res.add(curr.data);   
	            }
	            else{
	                rev.push(curr);
	            }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        if(leftToRight==0){
            while(!rev.isEmpty()){
	           res.add(rev.pop().data);
	       }
        }
        return res;
	}
}
