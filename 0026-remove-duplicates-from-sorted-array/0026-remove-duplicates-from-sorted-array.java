class Solution {
    public int removeDuplicates(int[] arr) {
       int left=0;
       int right=1;
       int res=1;
       while(right<arr.length){
          if(arr[right]==arr[left]){
            right++;
          }else{
            arr[res++]=arr[right];

            left=right;
            right++;
          }
       }

       return res;

    }
}