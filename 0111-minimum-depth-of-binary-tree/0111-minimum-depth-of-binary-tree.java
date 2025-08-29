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
    public int minHeight(TreeNode root, int height){
        if(root == null ) return 0;

        int left  =minHeight(root.left,height);
        int right =minHeight(root.right,height);

        if(left == 0|| right ==0 ){
            return height=Math.max(left,right)+1;
        }

        height=Math.min(left,right)+1;
        return height;
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        return minHeight(root,0);
    }
}