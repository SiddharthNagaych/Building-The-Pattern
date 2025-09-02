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
    
    public int sum(TreeNode root, boolean isLeftChild){
        if(root == null ) return 0;

        if(root.left == null && root.right == null && isLeftChild){
            return root.val;
        }
        int left =sum(root.left,true);
        int right = sum(root.right,false);
        return left+right;

    }
    public int sumOfLeftLeaves(TreeNode root) {
         return sum(root,false);

    }
}