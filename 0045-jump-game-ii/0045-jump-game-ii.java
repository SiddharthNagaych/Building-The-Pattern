class Solution {
    public int jump(int[] nums) {
       int destination=nums.length-1;
       int coverage=0;
       int jumps=0;
       int lastjumpidx=0;
       if(nums.length==1) return 0;
       // traversing  in the arr
       for(int i=0;i<nums.length;i++){
        coverage=Math.max(coverage,i+nums[i]);
        if(i==lastjumpidx){
            lastjumpidx=coverage;
            jumps++;
             // checking if we have already reeached to the destionation
             if(coverage>=destination){
                return jumps;
             }
        }
       
       }

       return jumps;
    }
}