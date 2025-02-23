class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end =s.length()-1;

        while(start<end){
            
            // moving to the valid element usingn these two loop form the left and right side
            while(start<end&& !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start<end&& !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }

            // checking that if the character at the starign and the ending index are not equal


            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }

            start++;
            end--;

        }


        return true;

    }
}