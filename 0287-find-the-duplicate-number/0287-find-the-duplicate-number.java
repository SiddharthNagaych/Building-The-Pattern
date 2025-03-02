class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        } while(slow != fast);


        int slow1=nums[0];
        while(slow1 != slow){
            slow=nums[slow];
            slow1=nums[slow1];
        }

        return slow1;

    }
}