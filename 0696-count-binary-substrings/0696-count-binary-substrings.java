class Solution {
    public int countBinarySubstrings(String s) {
        int res =0;
        int currCount =1;
        int prevCount =0;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)== s.charAt(i-1)){
                currCount++;
            }else{
                res +=Math.min(currCount,prevCount);
                prevCount=currCount;
                currCount=1;
            }
        }

        res += Math.min(currCount,prevCount);
        return res;
    }
}