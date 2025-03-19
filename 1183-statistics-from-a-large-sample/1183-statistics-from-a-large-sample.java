class Solution {
    public double[] sampleStats(int[] count) {
        int max =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        int totalCount=0;
        long sum =0;
        int maxFreq=0;
        int mode=0;
        int n=count.length;

        for(int i=0;i<n;i++){
            if(count[i]>0){
                if(i>max){
                    max=i;
                }
                if(i<min){
                    min=i;
                }

                sum += (long)count[i]*i;
                totalCount += count[i];

                if(count[i]>maxFreq){
                    maxFreq=count[i];
                    mode=i;
                }
            }
        }

        double mean =(double)sum / totalCount;

        // lets caculate the median as well

        double median=0;
        int currentCount=0;
        int medianPos=(totalCount+1)/2;
        boolean isEven=totalCount%2==0;

        for(int i =0;i<n;i++){
            if(count[i]>0){
             currentCount +=count[i];
             if(currentCount>=medianPos){
                if(!isEven || currentCount>medianPos){
                    median=i;
                }else{
                    for(int j=i+1;j<n;j++){
                        if(count[j]>0){
                            median =(i+j)/2.0;
                            break;
                        }
                    }
                }
                break;
             }
            }
        }

        return new double[]{min,max,mean,median,mode};


    }
}