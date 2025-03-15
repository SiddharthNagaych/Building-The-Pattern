class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        int idx = 0;
        int n = nums.length;

        while (right < n) {
            if (nums[left] == nums[right]) {
                right++; // Move right pointer if duplicates are found
            } else {
                // Copy at most two instances of the current element
                int count = Math.min(2, right - left); // Allow at most 2 duplicates
                for (int i = 0; i < count; i++) {
                    nums[idx++] = nums[left];
                }
                left = right; // Move left to the new element
                right++;
            }
        }

        // Handle the last set of duplicates
        int count = Math.min(2, right - left); // Allow at most 2 duplicates
        for (int i = 0; i < count; i++) {
            nums[idx++] = nums[left];
        }

        return idx; // Return the new length of the array
    }
}