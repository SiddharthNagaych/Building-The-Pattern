class Solution {
    public void dfs(List<List<Integer>> res,List<Integer> temp ,int idx,int [] nums){
       
        res.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
           temp.add(nums[i]);
           dfs(res,temp,i+1,nums);
           temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,new ArrayList<>(),0,nums);
        return res;

    }
}