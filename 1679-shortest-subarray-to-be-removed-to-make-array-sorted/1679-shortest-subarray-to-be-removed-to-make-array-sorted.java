class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        
        // Find the longest non-decreasing prefix
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // Already sorted
        if (left == n - 1) return 0;
        
        int right = n - 1;
        
        // Find the longest non-decreasing suffix
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Remove either left or right entirely
        int res = Math.min(n - left - 1, right);
        
        // Try to merge prefix and suffix
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                res = Math.min(res, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return res;
    }
}
