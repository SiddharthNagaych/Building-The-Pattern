class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        int idx=0;
        int n= nums.length;

        while(right<n){
            if(nums[left]== nums[right]){
                right++;
            }else{
                nums[idx++]=nums[left];
                left=right;
                right++;
            }
        } 
        nums[idx++]=nums[left];
        return idx;
    }
}