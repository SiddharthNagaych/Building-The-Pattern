class Solution {
    public boolean checkSubarraySum(int[] nums, int k){
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int prefixSum=0;
        if(nums.length<2){
            return false;
        }
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            prefixSum +=nums[i];

            if(k != 0){
                prefixSum %= k;
            }

            if(hm.containsKey(prefixSum)){
                if(i-hm.get(prefixSum)>=2)
                return true;
            }else{
                hm.put(prefixSum,i);
            }



            
        }

        return false;


        
    }
}