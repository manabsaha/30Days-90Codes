/* Approach: Use a stack and a temp Node to store the current parent.
*/

class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> n = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node temp = root;
        st.push(root);
        while(!st.empty()){
            if(temp!=null){
                temp = temp.left;
                if(temp!=null) st.push(temp);
            }
            else{
                Node curr = st.pop();
                n.add(curr.data);
                temp = curr.right;
                if(temp!=null) st.push(temp);
            }
        }
        return n;
    }
}
