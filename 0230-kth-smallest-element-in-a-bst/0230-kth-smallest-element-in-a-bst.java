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
    public void inOrder(TreeNode root,List<Integer> al){
        if(root == null) return;
        inOrder(root.left,al);
        al.add(root.val);
        inOrder(root.right,al);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> al=new ArrayList<>();
        inOrder(root,al);
        return al.get(k-1);

    }
}