class Solution {
    public int minMovesToMakePalindrome(String s) {
        int moves=0;
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>2){
            char ch1=sb.charAt(0);
            char ch2=sb.charAt(sb.length()-1);
            int idx=sb.indexOf(String.valueOf(ch2));
            if(ch1 != ch2 && idx==sb.length()-1) moves +=idx/2;
            else{
                moves += idx;
                sb.deleteCharAt(idx);
            }
            sb.setLength(sb.length()-1);
        }
        return moves;
    }
}