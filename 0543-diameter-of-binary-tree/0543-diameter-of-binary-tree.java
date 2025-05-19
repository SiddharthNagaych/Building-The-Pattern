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
    // Class variable to track the maximum diameter found
    private int maxDiameter = 0;
    
    public int heightCalculator(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = heightCalculator(root.left);
        int rightHeight = heightCalculator(root.right);

        // Calculate the diameter passing through this node
        int diameterThroughNode = leftHeight + rightHeight;
        
        // Update maxDiameter if we found a longer path
        maxDiameter = Math.max(maxDiameter, diameterThroughNode);
        
        // Return the height of this subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        // Reset maxDiameter (important for multiple test cases)
        maxDiameter = 0;
        
        // Calculate heights which will update maxDiameter
        heightCalculator(root);
        
        // Return the maximum diameter found
        return maxDiameter;
    }
}