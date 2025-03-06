class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n= stones.length;
        int [] res=new int[2];

        int max_value=Math.max(stones[n-1]-stones[1]-(n-2),stones[n-2]-stones[0]-(n-2));

        res[1]=max_value;

        int min_value=Integer.MAX_VALUE;

        int left=0;
        for(int right=0;right<n;right++){
            while(stones[right]-stones[left]+1>n){
                left++;
            }
            int longestSubWindow=right-left+1;

            if(longestSubWindow==n-1 && stones[right]-stones[left]+1==n-1){
                 min_value=Math.min(min_value,2);
            }else{
               min_value=Math.min(min_value,(n-longestSubWindow));
            }

            
        }

        res[0]=min_value;

        return res;




    }
}