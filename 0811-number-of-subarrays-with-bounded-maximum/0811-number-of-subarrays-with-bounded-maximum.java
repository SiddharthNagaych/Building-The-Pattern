class Solution {
    
    public int countMaxSubArray(int[] nums, int bound){
        int globalcount=0;
        int currentcount=0;
        for(int i:nums){
            if(i<=bound){
              currentcount++;
              globalcount +=currentcount;
            }else{
                currentcount=0;
            }
        }
        return globalcount;
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
       return countMaxSubArray(nums,right)-countMaxSubArray(nums,left-1);
    }
}