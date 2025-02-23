class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int mod=1000000007;
        int res =0;

        for(int i=0;i<arr.length-2;i++){
            int start=i+1;
            int end =arr.length-1;
            int remaining =target-arr[i];

            while(start<end){
                int sum =arr[start]+arr[end];
                if(sum ==remaining){
                    if(arr[start]==arr[end]){
                        int count=end-start+1;
                        res +=(count*(count-1))/2;
                        res %=mod;
                        break;

                    }else{
                        int leftCount=1;
                        int rightCount=1;

                        while(start+1<end &&arr[start]==arr[start+1]){
                            leftCount++;
                            start++;
                        }
                        while(end-1>start&&arr[end]==arr[end-1]){
                            rightCount++;
                            end--;
                        }

                        res +=(leftCount*rightCount);
                        res %=mod;
                        start++;
                        end--;








                    }
                }else if(sum <remaining){
                    start++;
                }else {
                    end--;
                }
            }
        }

        return (int)res; 


    }
}