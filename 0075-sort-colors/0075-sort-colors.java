class Solution {
    public void sortColors(int[] nums) {
        int count0=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count0++;
            }else if(nums[i]==1){
                count1++;
            }else{
                count2++;
            }
        }

        int global =0;

        for(int i=global;count0>0;i++){
            nums[i]=0;
            global++;
            count0--;
        }
         for(int i=global;count1>0;i++){
            nums[i]=1;
            global++;
            count1--;
        }
         for(int i=global;count2>0;i++){
            nums[i]=2;
            global++;
            count2--;
        }

        





    }
}