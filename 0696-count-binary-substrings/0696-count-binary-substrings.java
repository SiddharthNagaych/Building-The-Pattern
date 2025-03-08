class Solution {
   public int countBinarySubstrings(String s) {
    int[] groups = new int[s.length()]; // To store counts of consecutive 0s and 1s
    int groupIndex = 0; // Index for the groups array
    groups[groupIndex] = 1; // Initialize the first group

    // Step 1: Group the string into consecutive counts of 0s and 1s
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
            groups[groupIndex]++; // Increment the current group count
        } else {
            groupIndex++; // Move to the next group
            groups[groupIndex] = 1; // Initialize the new group
        }
    }

    // Step 2: Use a sliding window of size 2 to count valid substrings
    int result = 0;
    for (int i = 1; i <= groupIndex; i++) {
        result += Math.min(groups[i - 1], groups[i]); // Add the minimum of the two adjacent groups
    }

    return result;
}
}