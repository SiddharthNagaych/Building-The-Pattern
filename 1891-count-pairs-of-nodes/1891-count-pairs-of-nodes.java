class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
       
        int[] degree = new int[n + 1]; // Store degrees of nodes
        Map<Integer, Integer> edgeCount = new HashMap<>(); // Store edge frequency

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            int min = Math.min(u, v), max = Math.max(u, v);
            edgeCount.put(min * (n + 1) + max, edgeCount.getOrDefault(min * (n + 1) + max, 0) + 1);
        }
        
        int[] sortedDegrees = degree.clone();
        Arrays.sort(sortedDegrees);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int count = 0;

            // Two pointers approach to count valid pairs
            int left = 1, right = n;
            while (left < right) {
                if (sortedDegrees[left] + sortedDegrees[right] > q) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }

            // Adjust for overcounted pairs due to common edges
            for (int key : edgeCount.keySet()) {
                int u = key / (n + 1), v = key % (n + 1);
                if (degree[u] + degree[v] - edgeCount.get(key) <= q && degree[u] + degree[v] > q) {
                    count--;
                }
            }

            result[i] = count;
        }
        return result;
    }
}