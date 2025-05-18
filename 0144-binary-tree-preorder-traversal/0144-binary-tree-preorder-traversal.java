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
    
   
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode current=root;

        while(current != null || !st.isEmpty()){
            while( current != null  ){
                res.add(current.val);
                st.push(current);
                current=current.left;
            }

            current=st.pop();
            current=current.right;
            
        }
        return res;

        
    }
}