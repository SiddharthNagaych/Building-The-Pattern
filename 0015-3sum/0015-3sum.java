class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2){
            
            if(i>0&& nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int target=-nums[i];
            int start=i+1;
            int end =nums.length-1;
            while(start<end){
                int sum =nums[start]+nums[end];
                if(sum==target){
                    res.add(Arrays.asList(nums[i],nums[end],nums[start]));

                    while(start<end &&nums[start]==nums[start+1]){start++;}
                    while(start<end &&nums[end]==nums[end-1]){end--;}
                    start++;
                    end--;

                } else if(sum <target){
                    start++;
                }else{
                    end--;
                }

            }
            i++;
        }
        return res;

    }
}