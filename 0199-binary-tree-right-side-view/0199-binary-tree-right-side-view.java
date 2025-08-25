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
    public void bfs(TreeNode root,List<Integer> al){
       if(root == null)return;

       Queue<TreeNode> q=new LinkedList<>();
       q.offer(root);


       while(!q.isEmpty()){
         
          TreeNode rightMost = null;
          int n =q.size();

          for(int i=0;i<n;i++ ){
            TreeNode curr=q.poll();
            rightMost= curr;

            if(curr.left!= null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
          }
          al.add(rightMost.val);
       }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        bfs(root,al);
        return al;
    }
}