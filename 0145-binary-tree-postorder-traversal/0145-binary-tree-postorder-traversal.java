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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
      
        Stack<TreeNode> st=new Stack<>();
        TreeNode current=root;
        TreeNode lastVisited=null;
     

        while(current != null || !st.isEmpty()){
            if(current != null){
            st.push(current);
            current=current.left;
             }else{
             TreeNode peekNode =st.peek();
             if(peekNode.right != null && lastVisited != peekNode.right){
                  current=peekNode.right; 
             }else{
                res.add(peekNode.val);
                lastVisited=st.pop();
             }

             }
        }
        return res;

    }
}