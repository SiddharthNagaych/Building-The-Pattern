class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=1;
        int n=nums.length;

        while(right<n){
           int remainingTarget=target-nums[left];
           for(int i=right;i<n;i++){
            if(nums[i] == remainingTarget) return new int[]{left,i};
           }
           left++;
           right++;
        }

        return new int[2];
    }
}