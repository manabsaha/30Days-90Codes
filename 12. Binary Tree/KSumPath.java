/*Leetcode 437:
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes). */

class Solution {
    static int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        ArrayList<Integer> path = new ArrayList<>();
        printKNodes(root,path,targetSum);
        return count;
    }
    
    void printKNodes(TreeNode root, ArrayList<Integer> path, int sum){
        if(root==null){
            return;
        }
        path.add(root.val);
        printKNodes(root.left,path,sum);
        printKNodes(root.right,path,sum);
        
        int temp = 0;
        for(int i=path.size()-1;i>=0;i--){
            temp += path.get(i);
            if(temp==sum){
                //printVector(path,i)
                count += 1;
            }
        }
        path.remove(path.size()-1);
    }
}
