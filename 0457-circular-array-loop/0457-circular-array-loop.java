class Solution {
    public boolean circularArrayLoop(int[] nums) {
       int n=nums.length;

       for(int i=0;i<nums.length;i++){
         if(nums[i]==0){
            continue;
         }

         int slow=i;
         int fast=i;

         boolean direction=nums[i]>0;

         while(true){
            slow=getNextJumpIdx(nums,slow,n);
            if(nums[slow] ==0 || (nums[slow]>0) != direction){
                break;
            } 
            fast=getNextJumpIdx(nums,fast,n);
            if(nums[fast] ==0 || (nums[fast]>0) != direction){
                break;
            } 
            fast=getNextJumpIdx(nums,fast,n);
            if(nums[fast] ==0 || (nums[fast]>0) != direction){
                break;
            } 

            if(slow == fast){
                int nextSlow=getNextJumpIdx(nums,slow,n);
                if(slow ==nextSlow){
                    break;
                }
                return true;
            }

            
         }

          slow =i;
          while(nums[slow] != 0&& (nums[slow]>0) == direction){
             int nextSlow=getNextJumpIdx(nums,slow,n);
             nums[slow]=0;
             slow=nextSlow;
          }

       }
       return false;
    }

    public int getNextJumpIdx(int []nums,int current,int n){
        int next=(current+nums[current])%n;
        if(next<0){
            next +=n;
        }

        return next;
    }
}