class Solution {
    
    public int countMaxSubArray(int[] nums, int bound ){
        int count =0;
        int currentCount=0;
        for(int i:nums){
            if(i<=bound){
                currentCount++;
                count +=currentCount;
            }else{
                currentCount=0;
            }
        }

        return count;
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
       return countMaxSubArray(nums,right)-countMaxSubArray(nums,left-1);
    }
}