class Solution {
    public int compress(char[] chars) {
       int left=0;
       int right=1;
       int ind=0;
       int n=chars.length;

       while(right<=n){
        if(right==n||chars[left]!=chars[right]){
            chars[ind++]=chars[left];

            if(right-left>1){
               for(char c:String.valueOf(right-left).toCharArray() ){
                chars[ind++]=c;
               }

            }
            left=right;
        }

        
        
        
        
        right++;
       } 
       return  ind;
    }
}