class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;

        int minimumDistance=0;
        int maximumDistance=nums[n-1]-nums[0];

        while(minimumDistance<maximumDistance){
            int midDistance=minimumDistance +(maximumDistance-minimumDistance)/2;

            int left=0;
            int count=0;

            for(int right=0;right<n;right++){
                while(nums[right]-nums[left]>midDistance){
                    left++;
                }
                count +=right-left;
            }

            if(count<k){
             minimumDistance =midDistance+1;
            }else{
                maximumDistance=midDistance;
            }
        }

        return minimumDistance;
    }
}