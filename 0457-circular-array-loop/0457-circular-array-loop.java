public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue; 
            }
            
            int slow = i, fast = i;
            boolean direction = nums[i] > 0; 
            
            while (true) {
                slow = getNextIndex(nums, slow, n);
                if (nums[slow] == 0 || (nums[slow] > 0) != direction) {
                    break; 
                }
                
                fast = getNextIndex(nums, fast, n);
                if (nums[fast] == 0 || (nums[fast] > 0) != direction) {
                    break;
                }
                fast = getNextIndex(nums, fast, n);
                if (nums[fast] == 0 || (nums[fast] > 0) != direction) {
                    break; 
                }
                
                if (slow == fast) {
                  
                    int nextSlow = getNextIndex(nums, slow, n);
                    if (nextSlow == slow) {
                        break; 
                    }
                    return true; 
                }
            }
            
         
        }
        
        return false; 
    }
    
    private int getNextIndex(int[] nums, int current, int n) {
        int next = (current + nums[current]) % n;
        if (next < 0) {
            next += n;
        }
        return next;
    }
}