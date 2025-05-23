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
    private int maxLength=0;
    public int maxZigZag(TreeNode root,Boolean isLeft,int length){
        if(root == null ) return 0;
        maxLength=Math.max(maxLength,length);

        if(isLeft){
           maxZigZag(root.left,false,length+1);
           maxZigZag(root.right,true,1);
        }else{
           maxZigZag(root.right,true,length+1);
           maxZigZag(root.left,false,1);
        }

        return maxLength;


    }
    public int longestZigZag(TreeNode root) {
        maxZigZag(root.left,false,1);
        maxZigZag(root.right,true,1);
        return maxLength;
    }
}