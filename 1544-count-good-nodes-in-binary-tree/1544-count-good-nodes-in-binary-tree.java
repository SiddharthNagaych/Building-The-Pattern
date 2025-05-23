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
    private int goodNodesCount = 0;

    private void dfs(TreeNode node, int maxSoFar) {
        if (node == null) return;

        if (node.val >= maxSoFar) {
            goodNodesCount++;
        }

        maxSoFar = Math.max(maxSoFar, node.val);
        dfs(node.left, maxSoFar);
        dfs(node.right, maxSoFar);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);  // start with root.val as the initial max
        return goodNodesCount;
    }
}
