class Solution {
    
    public boolean distanceChecker(int [] arr,int d,int currElement){
        int left =0;
        int right=arr.length-1;

        while(left<=right){
            int mid =left+(right-left)/2;
            int dif=Math.abs(arr[mid]-currElement);
            if(dif<=d){
                return false;
            }else if(arr[mid]<currElement) {
                left=mid+1;
            }else{
                right=mid-1;
            }
           
        }
         return true;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
       Arrays.sort(arr2);
       int res=0;

       for(int num:arr1){
          if(distanceChecker(arr2,d,num)){
            res++;
          }else{
            continue;
          }
       }
       return res;
       
      
    }
}