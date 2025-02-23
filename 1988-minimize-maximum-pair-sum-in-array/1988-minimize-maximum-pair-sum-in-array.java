class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start=0;
        int end =nums.length-1;
        int sum =Integer.MIN_VALUE;
        while(start<end){
            int firstElementOfPair=nums[start];
            int secondElementOfPair=nums[end];
            int currsum =firstElementOfPair+secondElementOfPair;

            sum =Math.max(sum,currsum);
            start++;
            end--;

        }

        return sum;
    }
}