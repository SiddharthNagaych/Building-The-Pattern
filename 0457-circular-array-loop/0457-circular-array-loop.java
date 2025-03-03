public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue; // Skip already visited indices
            }
            
            int slow = i, fast = i;
            boolean direction = nums[i] > 0; // true for positive, false for negative
            
            while (true) {
                slow = getNextIndex(nums, slow, n);
                if (nums[slow] == 0 || (nums[slow] > 0) != direction) {
                    break; // Invalid cycle (direction mismatch or visited)
                }
                
                fast = getNextIndex(nums, fast, n);
                if (nums[fast] == 0 || (nums[fast] > 0) != direction) {
                    break; // Invalid cycle (direction mismatch or visited)
                }
                fast = getNextIndex(nums, fast, n);
                if (nums[fast] == 0 || (nums[fast] > 0) != direction) {
                    break; // Invalid cycle (direction mismatch or visited)
                }
                
                if (slow == fast) {
                    // Check if the cycle length is at least 2
                    int nextSlow = getNextIndex(nums, slow, n);
                    if (nextSlow == slow) {
                        break; // Cycle length is 1 (invalid)
                    }
                    return true; // Valid cycle found
                }
            }
            
            // Mark all visited indices in the current path as 0 to avoid reprocessing
            slow = i;
            while (nums[slow] != 0 && (nums[slow] > 0) == direction) {
                int nextSlow = getNextIndex(nums, slow, n);
                nums[slow] = 0; // Mark as visited
                slow = nextSlow;
            }
        }
        
        return false; // No valid cycle found
    }
    
    private int getNextIndex(int[] nums, int current, int n) {
        int next = (current + nums[current]) % n;
        if (next < 0) {
            next += n; // Handle negative indices
        }
        return next;
    }
}