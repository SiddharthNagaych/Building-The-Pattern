class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCount=0;
        int n=arr.length;
        for(int i:arr){
            if(i==0){
               zeroCount++;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i+zeroCount<n){
                arr[i+zeroCount]=arr[i];
            }

            if(arr[i]==0){
                zeroCount--;
                if(i+zeroCount<n){
                arr[i+zeroCount]=0;
            }
            }
        }
    }
}