import java.util.Arrays;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones); // Sort the stones array
        int n = stones.length;
        int[] res = new int[2]; // Result array: [min_moves, max_moves]

        // Calculate maximum moves
        int maxMoves = Math.max(
            stones[n - 1] - stones[1] - (n - 2), // Move stones from the right end
            stones[n - 2] - stones[0] - (n - 2)  // Move stones from the left end
        );
        res[1] = maxMoves;

        // Calculate minimum moves
        int minMoves = Integer.MAX_VALUE;
        int left = 0;

        // Use a sliding window to find the largest window of consecutive stones
        for (int right = 0; right < n; right++) {
            while (stones[right] - stones[left] + 1 > n) {
                left++; // Shrink the window from the left
            }
            int windowSize = right - left + 1; // Size of the current window
            if (windowSize == n - 1 && stones[right] - stones[left] + 1 == n - 1) {
                // Special case: only one gap of size 2
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - windowSize);
            }
        }
        res[0] = minMoves;

        return res;
    }
}