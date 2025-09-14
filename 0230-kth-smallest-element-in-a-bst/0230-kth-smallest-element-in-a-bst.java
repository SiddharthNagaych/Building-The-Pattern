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

    public int kthSmallest(TreeNode root, int k) {
         int count = 0;
         TreeNode current =root;
         int res=0;
         while(current != null){
            if(current.left == null){
                 count++;
                 if(count == k){
                    res =current.val;
                 }
                 current=current.right;
            }else{
                TreeNode pre=current.left;
                while(pre.right != null && pre.right != current){
                    pre=pre.right;
                }

                if(pre.right == null){
                    pre.right=current;
                    current=current.left;
                }else{
                    pre.right =null;
                    count++;
                    if(count == k){
                        res =current.val;
                    }
                    current =current.right;
                }
            }
         }
         return res;
    }
}