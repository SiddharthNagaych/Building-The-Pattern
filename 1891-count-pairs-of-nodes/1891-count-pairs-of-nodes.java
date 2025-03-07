class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int [] degree=new int [n+1];

        HashMap<Integer,Integer> edgeCount=new HashMap<>();

        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            degree[u]++;
            degree[v]++;
            int min=Math.min(u,v);
            int max=Math.max(u,v);
            edgeCount.put(min*(n+1)+max,edgeCount.getOrDefault(min*(n+1)+max,0)+1);
        }

         // we have succefully counted the total number of edges between the each pairt it alos inlcue the repeated one       

        int [] sortedDegree=degree.clone();
        Arrays.sort(sortedDegree);

         int [] res=new int[queries.length];

         for(int i=0;i<queries.length;i++){
            int threshold=queries[i];

            int count=0;

            int left=1;
            int right=n;

            while(left<right){
                if(sortedDegree[left]+sortedDegree[right]>threshold){
                    count +=(right-left);
                    right--;
                }else{
                    left++;
                }
            }
            for(int key:edgeCount.keySet()){
                int u=key/(n+1);
                int v=key%(n+1);
                if(degree[u]+degree[v]>threshold && degree[u]+degree[v]-edgeCount.get(key)<=threshold){
                    count--;
                }

            }

            res[i]=count;


         }

         return res;

    }
}