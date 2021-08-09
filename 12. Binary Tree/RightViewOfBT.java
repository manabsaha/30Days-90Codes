/* Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side. 
Approach: Level Order Traversal -> RightMost Node */

class Solution{
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> right = new ArrayList<>();
        if(root==null) return right;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int last = 1;
        while(q.size()>1){
            Node curr = q.poll();
            if(curr==null){
                q.add(null);
                last = 1;
            }
            else{
                if(last==1){
                    right.add(curr.data);
                    last = 0;
                }
                if(curr.right!=null)
                    q.add(curr.right);
                if(curr.left!=null)
                    q.add(curr.left);
            }
        }
        return right;
    }
}
