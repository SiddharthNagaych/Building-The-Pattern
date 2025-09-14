class Solution {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) return;
        
        inOrder(node.left);
        
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        
        inOrder(node.right);
    }
}