class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            // slow is moving one step at a time and fast is moving two step at a time
            slow=nums[slow];
            fast=nums[nums[fast]];
        }  while(slow !=fast);

        int slow1=nums[0];
        int slow2=slow;

        while(slow1!=slow2){
            slow1=nums[slow1];
            slow2=nums[slow2];
        }
        return slow1;
    }
}