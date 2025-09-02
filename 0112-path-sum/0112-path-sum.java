/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean dfs(TreeNode root,int targetSum,int currentSum  ){
        if(root == null) return false;


        
        currentSum += root.val;
        if(root.left == null && root.right == null ){
            return currentSum == targetSum;
        }

        

       
       

        return dfs(root.left,targetSum,currentSum) || dfs(root.right,targetSum,currentSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root,targetSum,0);
    }
}