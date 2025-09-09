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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // Base case: node not found or tree is empty
        }

        // Traverse the tree
        if (key < root.val) { // Key is smaller, search in the left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) { // Key is larger, search in the right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted is found
            // Case 1: No child or one child (null check handles both)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

           
            root.val = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteNode(root.right, root.val);
        }

        return root; // Return the updated root
    }

    // Helper method to find the minimum value in a subtree
    static int minValue(TreeNode root) {
        while (root.left != null) {
            root = root.left; // Go as left as possible
        }
        return root.val; // Return the leftmost value
    }
}
