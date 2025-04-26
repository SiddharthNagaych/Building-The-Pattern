class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand left while strictly increasing
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand right while strictly decreasing
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Update the longest length
                longest = Math.max(longest, right - left + 1);
            }
        }

        return longest;
    }
}
