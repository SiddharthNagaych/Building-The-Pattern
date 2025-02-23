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
    public boolean bfs(TreeNode root, int k,HashSet<Integer> hs,Queue<TreeNode> q){
        if(root ==null) return false;

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            int diff=k-curr.val;

            if(hs.contains(diff)){
                return true;
            }

            hs.add(curr.val);

            if(curr.left !=null) q.offer(curr.left);
            if(curr.right !=null) q.offer(curr.right);

        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<Integer> hs=new HashSet<>();
        return bfs(root,k,hs,q);
    
    }
}