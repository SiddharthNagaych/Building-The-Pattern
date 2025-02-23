class Solution {
    public int trap(int[] arr) {
        int leftMax=0;
        int rightMax=0;
        int totalTrappedWater=0;
        int start=0;
        int end =arr.length-1;

        while(start<end){
            if(arr[start]<arr[end]){
                if(arr[start]>leftMax){
                   leftMax=arr[start];
                }else{
                    totalTrappedWater +=leftMax-arr[start];
                }
                start++;
            }else{
                if(arr[end]>rightMax){
                    rightMax=arr[end];
                }else{
                    totalTrappedWater += rightMax-arr[end];
                }
                end--;
            }
        }
        return totalTrappedWater;
    }
}