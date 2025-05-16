class Solution {
    public int[] twoSum(int[] arr, int target) {
   
        for(int i=0;i<arr.length;i++){
            int remainingSum=target-arr[i];
            int j=i+1;
            while(j<arr.length){
                if(arr[j]==remainingSum){
                    return new int []{i+1,j+1};
                }
                j++;
            }
        }

        return new int [2];

    }
}