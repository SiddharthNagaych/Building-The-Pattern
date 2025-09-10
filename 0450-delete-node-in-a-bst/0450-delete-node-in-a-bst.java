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

    public int minNode(TreeNode root) {
        if (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public TreeNode dfs(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val < key) {
            root.right = dfs(root.right, key);
        } else if (root.val > key) {
            root.left = dfs(root.left, key);
        } else {

            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {

                root.val = minNode(root.right);
                root.right = dfs(root.right, root.val);
            }
           
        }
         return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        return dfs(root, key);
    }
}