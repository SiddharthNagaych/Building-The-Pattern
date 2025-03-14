class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: empty array

        int left = 0;
        int right = 1;
        int idx = 0;
        int n = nums.length;

        while (right < n) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[idx] = nums[left]; // Assign the unique element to nums[idx]
                idx++;
                left = right;
                right++;
            }
        }

        // Add the last unique element
        nums[idx] = nums[left];
        idx++;

        return idx; // Return the number of unique elements
    }
}