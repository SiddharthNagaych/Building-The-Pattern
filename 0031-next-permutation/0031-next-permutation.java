class Solution {
    public void swap(int []nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int []nums,int start){
        int end=nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }

    }
    public void nextPermutation(int[] nums) {
       int i=nums.length-2;
       while(i>=0&&nums[i]>=nums[i+1]){
        i--;
       }
       
      
       if(i>=0){
       int j=nums.length-1;
       while(j>i&&nums[i]>=nums[j]){
        j--;
       }
       swap(nums,i,j);
       }

       

       reverse(nums,i+1);






    }
}