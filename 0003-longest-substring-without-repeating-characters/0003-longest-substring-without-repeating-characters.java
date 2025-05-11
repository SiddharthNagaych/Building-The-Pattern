class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxCount=0;
       int start =0;
       int count=0;
       HashSet<Character> hs=new HashSet<>();
       for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         while(hs.contains(ch)){
            hs.remove(s.charAt(start));
            start++;
            count--;
         }

         hs.add(ch);
         count++;
         maxCount=Math.max(maxCount,count);
       }

       return maxCount;
    }
}