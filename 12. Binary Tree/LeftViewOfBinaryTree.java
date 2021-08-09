/* Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. 
The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.
          1
       /     \
     2        3
   /   \    /   \
  4     5   6    7
   \
     8   
*/

class Solution
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> left = new ArrayList<>();
        if(root==null) return left;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int first = 1;
        while(q.size()>1){
            Node curr = q.poll();
            if(curr==null){
                q.add(null);
                first = 1;
            }
            else{
                if(first==1){
                    left.add(curr.data);
                    first = 0;
                }
                if(curr.left!=null) 
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return left;
    }
}
