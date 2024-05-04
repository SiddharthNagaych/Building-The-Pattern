class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        List<int[]> finallist=new ArrayList<>();
        // taking out the first subarray of the interval so that we can compare it next
        int [] curr_interval=intervals[0];
        finallist.add(curr_interval);
        // start traversing into the 2-d array
        for(int i=1;i<intervals.length;i++){
            int fiin_begin=curr_interval[0];
            int fiin_end=curr_interval[1];
            int sein_begin =intervals[i][0];
            int sein_end=intervals[i][1];
            if(fiin_end>=sein_begin){
                curr_interval[1]=Math.max(fiin_end,sein_end);
            }else {
                curr_interval=intervals[i];
                finallist.add(curr_interval);
            }
            
        }
         return finallist.toArray(new int [finallist.size()][]);
    }
}