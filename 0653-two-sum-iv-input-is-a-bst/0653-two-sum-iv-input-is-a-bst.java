class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        return inorderHelper(root, k, hm);
    }
    
    public boolean inorderHelper(TreeNode root, int k, HashMap<Integer, Integer> hm) {
        if (root == null) return false;
        
        // First traverse left subtree
        if (inorderHelper(root.left, k, hm)) {
            return true;
        }
        
        // Check if complement exists in HashMap
        if (hm.containsKey(root.val)) {
            return true;
        }
        
        // Add current value to HashMap
        hm.put(k-root.val, 1);
        
        // Then traverse right subtree
        return inorderHelper(root.right, k, hm);
    }
}