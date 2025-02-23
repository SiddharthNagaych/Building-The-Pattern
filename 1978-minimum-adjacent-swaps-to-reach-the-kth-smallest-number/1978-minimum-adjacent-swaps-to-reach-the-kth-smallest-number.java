class Solution {
    
    public void swap(char []arr,int a,int b){
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void reverse(char []arr,int start){
        int end =arr.length-1;
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    public String permutation(String num){
        char [] arr=num.toCharArray();
        int i=arr.length-2;


        while(i>0&&arr[i]>=arr[i+1]){
            i--;
        }

        if(i>=0){
            int j=arr.length-1;
            while(j>=i&&arr[i]>=arr[j]){
                j--;
            }

            swap(arr,i,j);
        }

        reverse(arr,i+1);

        return new String(arr);
    }

    public int countSwap(String original,String target){
        char []orig=original.toCharArray();
        char []tar=target.toCharArray();
        int swap =0;

        for(int i=0;i<orig.length;i++){
            if(orig[i]!=tar[i]){
                int j=i+1;
                while(orig[j]!=tar[i]){
                    j++;
                }

              
                while(j>i){
                        swap(orig,j,j-1);
                        swap++;
                        j--;
                }
               
            }
        }

        return swap;
        
    }
    
    
    public int getMinSwaps(String num, int k) {
        String target=num;
        for(int i=0;i<k;i++){
            target=permutation(target);
        }

        return countSwap(num,target);
    }
}