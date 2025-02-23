class Solution {
    
    public void swap(int []nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public int removeElement(int[] nums, int val) {
        int start=0;
        int end =nums.length-1;
        while(start<=end){
            if(nums[start]==val){
                swap(nums,start,end);
                end--;
            }else{
                start++;
            }
        }

        return end+1;
    }
}