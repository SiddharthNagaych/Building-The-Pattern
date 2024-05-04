class Solution {
    private void swap(int []nums,int a ,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;

    }
    private void reverse(int []nums,int start){
        int end=nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    
    public void nextPermutation(int[] nums) {
       // inteiallizing i with the second last index 
       int i=nums.length-2;
       //finding the index at which the element is less than the next element
       while(i>=0&&nums[i]>=nums[i+1]){
        i--;
       } 
       // finding the index at which the element is just greatet than the elment at i 
       if(i>=0){
        int j=nums.length-1;
        while(j>i&&nums[i]>=nums[j]){
            j--;
        }
        // swaping numbers at i and j
        swap(nums,i,j);

       }
       // for minimizing the number we have to revese the arr as well
       reverse(nums,i+1);
    }
}