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
    public void preorder(TreeNode root, ArrayList<Integer> al){
        if(root == null) return;
        al.add(root.val);
        preorder(root.left,al);
        preorder(root.right,al);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
         ArrayList<Integer> al=new ArrayList<>();
         preorder(root,al);
         return al;
        
    }
}