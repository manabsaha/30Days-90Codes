/* GFG: Sorted array to (h-b) BST.
Given a sorted array. Convert it into a Height balanced Binary Search Tree (BST). Find the preorder traversal of height balanced BST. 
If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.
Height balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1.
*/

class Node{
    int data;
    Node left = null;
    Node right = null;
    Node(int d){
        data = d;
    }
}

class Solution
{
    ArrayList<Integer> pre = new ArrayList<>();
    public int[] sortedArrayToBST(int[] nums)
    {
        Node root = buildBST(nums,0,nums.length-1);
        preorder(root);
        int[] res = pre.stream().mapToInt(i -> i).toArray();
        return res;
    }
    
    //function to build balanced bst from sorted array.
    Node buildBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(nums[mid]);
        //build left subtree.
        root.left = buildBST(nums,start,mid-1);
        //build right subtree.
        root.right = buildBST(nums,mid+1,end);
        return root;
    }
    
    void preorder(Node root){
        if(root==null){
            return;
        }
        pre.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    
}
