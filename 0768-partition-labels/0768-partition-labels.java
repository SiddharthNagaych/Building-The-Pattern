class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        
        int [] lastOccurence=new int[26];
        for(int i=0;i<n;i++){
            lastOccurence[s.charAt(i)-'a']=i;
        }

        int start=0;
        int end =0;
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            end =Math.max(lastOccurence[s.charAt(i)-'a'],end);

            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }

        return res;


    }
}