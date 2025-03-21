class Solution {
    public int magicalString(int n) {
        if(n==0) return 0;
        if(n<=3) return 1;
        int [] arr=new int[n+1];
        arr[0]=1;
        arr[1]=2;
        arr[2]=2;

        int countOnes=1;
        int readPointer=2;
        int writePointer=3;

        while(writePointer<n){
            int nextGrpSize=arr[readPointer];
            int nextChar=arr[writePointer-1]==1?2:1;

            for(int i=0;i<nextGrpSize;i++){
                if(writePointer<n){
                    arr[writePointer]=nextChar;
                    if(nextChar==1){
                        countOnes++;
                    }
                    writePointer++;
                }
            }
            readPointer++;
        }


        return countOnes;

    }
}