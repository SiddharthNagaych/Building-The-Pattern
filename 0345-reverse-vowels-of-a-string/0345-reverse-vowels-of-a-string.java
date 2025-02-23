class Solution {
    
    public void swap(char [] arr,int a,int b){
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public boolean isVowel(char ch ){
        char isLowerOrUpper=Character.toLowerCase(ch);
        return isLowerOrUpper=='a'||isLowerOrUpper=='e'||isLowerOrUpper=='i'||isLowerOrUpper=='o'||isLowerOrUpper=='u';
    }


    public String reverseVowels(String s) {
        
        char [] arr=s.toCharArray();
        int start=0;
        int end =arr.length-1;
        while(start<end){
            if(!isVowel(arr[start])){
                start++;
                continue;
            }
            if(!isVowel(arr[end])){
                end--;
                continue;
            }

            swap(arr,start,end);
            start++;
            end--;
            

        }

        return new String(arr);

    }
}