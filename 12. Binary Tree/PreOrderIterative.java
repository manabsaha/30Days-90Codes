class Solution
{
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> n = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            Node curr = st.pop();
            n.add(curr.data);
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.left);
            
        }
        return n;
    }

}
