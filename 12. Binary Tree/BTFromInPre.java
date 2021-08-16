/* Given 2 Arrays of Inorder and preorder traversal. 
Construct a tree and print the Postorder traversal.  
Time: O(n)
Space: O(n) */

class Solution
{
    static HashMap<Integer,Integer> inMap = new HashMap<>();
    static int index = 0;
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        index = 0;
        //store inorder to map.
        for(int i=0;i<n;i++){
            inMap.put(inorder[i],i);
        }
        //build the tree.
        Node root = build(inorder,preorder,0,n-1);
        return root;
    }
    
    public static Node build(int[] inorder,int[] preorder,int m,int n)
    {
        //array empty
        if(m>n){
            return null;
        }
        Node node = new Node(preorder[index++]);
        //array length 1
        if(m==n){
            return node;
        }
        //else recursively build right and left.
        int mid = inMap.get(node.data);
        node.left = build(inorder,preorder,m,mid-1);
        node.right = build(inorder,preorder,mid+1,n);
        return node;
    }
}
