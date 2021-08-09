/* Approach: Using two stacks.
1) Push root to stack
2) Pop stack 1 and push to stack 2  
3) Push left & right to stack 1
4) Repeat from 2 while stack 1 is not empty
*/

class Solution
{
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> n = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.empty()){
            Node curr = st1.pop();
            st2.push(curr);
            if(curr.left!=null) st1.push(curr.left);
            if(curr.right!=null) st1.push(curr.right);
        }
        while(!st2.empty()){
            n.add(st2.pop().data);
        }
        return n;
    }
}
