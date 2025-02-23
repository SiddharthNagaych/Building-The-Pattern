class Solution {
    
    public void swap(int []arr,int a ,int b){
        int temp =arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void reverse(int []arr,int start){
        int end =arr.length-1;
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    
    
    public void nextPermuation(int []arr){
        int i=arr.length-2;
        while(i>=0&&arr[i]>=arr[i+1]){
            i--;
        }

        if(i>=0){
            int j=arr.length-1;
            while(j>=0&&arr[i]>=arr[j]){
                j--;
            }
            swap(arr,i,j);
           
        }

        reverse(arr,i+1);
        
    }
    public int nextGreaterElement(int n) {
        String numberToArray=Integer.toString(n);

        int [] arr=new int [numberToArray.length()];

        for(int i=0;i<numberToArray.length();i++){
            arr[i]=Character.getNumericValue(numberToArray.charAt(i));
        }

        nextPermuation(arr);

        long result=0;

        for(int digit:arr){
            result =result*10+digit;
        }

        if(result>Integer.MAX_VALUE){
            return -1;
        }

        if(result<=n){
            return -1;
        }

        return (int)result;



    }
}