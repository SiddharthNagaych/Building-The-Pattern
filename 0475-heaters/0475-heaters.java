public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int maxRadius = 0;

        for (int house : houses) {
            int closestDist = findClosestHeaterDistance(house, heaters);
            maxRadius = Math.max(maxRadius, closestDist);
        }

        return maxRadius;
    }

    private int findClosestHeaterDistance(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int dist1 = (right >= 0) ? Math.abs(house - heaters[right]) : Integer.MAX_VALUE;
        int dist2 = (left < heaters.length) ? Math.abs(house - heaters[left]) : Integer.MAX_VALUE;

        return Math.min(dist1, dist2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        System.out.println(sol.findRadius(houses, heaters)); // Output: 1
    }
}
