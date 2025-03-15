class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        int idx=0;
        int n=nums.length;

        while(right<n){
            if(nums[left]==nums[right]){
                right++;
            }else{
                int count=Math.min(2,right-left);

                for(int i=0;i<count;i++){
                    nums[idx++]=nums[left];
                }
                left=right;
                right++;
            }
        }

        int count=Math.min(2,right-left);
        for(int i=0;i<count;i++){
            nums[idx++]=nums[left];
        }

        return idx;


    }
}