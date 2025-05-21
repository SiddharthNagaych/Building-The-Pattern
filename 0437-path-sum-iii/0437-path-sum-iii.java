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
    
    public int pathSumCalculator(TreeNode root,Long currentSum,int targetSum,HashMap<Long,Integer> hm){
        if(root == null){
            return 0;
        }

        currentSum += root.val;

        int count =hm.getOrDefault(currentSum-targetSum,0);

        hm.put(currentSum,hm.getOrDefault(currentSum,0)+1);

        count +=pathSumCalculator(root.left,currentSum,targetSum,hm);
        count +=pathSumCalculator(root.right,currentSum,targetSum,hm);

        hm.put(currentSum,hm.get(currentSum)-1);
        return count;

        
    }
    public int pathSum(TreeNode root, int targetSum) {
       HashMap<Long,Integer> hm =new HashMap<>();
       hm.put(0L,1);
      
       return  pathSumCalculator(root,0L,targetSum,hm);
        

    }
}