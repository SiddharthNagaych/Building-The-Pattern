class Solution {
    
    public void reverseWord(char [] arr,int n){
        int start=0;

        for(int end=0;end<n;end++){
            if(arr[end]==' '){
                flip(arr,start,end-1);
                start=end+1;
            }
        }
        flip(arr,start,n-1);
    }
    
    public void flip(char [] arr,int start,int end){
        while(start<end){
          char temp=arr[start];
          arr[start]=arr[end];
          arr[end]=temp;
          start++;
          end--;
        }
    }

    public String removeExtraSpace(char [] arr,int n){
        int i=0;
        int j=0;
        while(j<n){
            while(j<n&&arr[j]==' '){
                j++;
            }
            while(j<n&&arr[j] !=' '){
                arr[i++]=arr[j++];
            }
            while(j<n && arr[j]==' '){
                j++;
            }
            if(j<n) arr[i++]=' ';
        }

        return new String(arr,0,i);
    }
    public String reverseWords(String s) {
        char [] arr=s.toCharArray();
        int n=arr.length;

        flip(arr,0,n-1);
        reverseWord(arr,n);
        return removeExtraSpace(arr,n);

    }
}