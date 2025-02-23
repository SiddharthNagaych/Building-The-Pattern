class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> res=new ArrayList<>();
        int start=0;
        int end =arr.length-k;

        while(start<end){
            int mid=start+(end-start)/2;
            if(x-arr[mid]>arr[mid+k]-x){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        for(int i=start;i<start+k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}