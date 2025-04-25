class Solution {
    // Find the index of the first element > num
    public int upperBound(int[] ages, int num) {
        int low = 0;
        int high = ages.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ages[mid] <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    // Find the index of the first element >= num
    public int lowerBound(int[] ages, int num) {
        int low = 0;
        int high = ages.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ages[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            int currAge = ages[i];
            // Based on the age rule: age[y] <= 0.5 * age[x] + 7 (not allowed)
            // So we want age[y] > 0.5 * age[x] + 7
            int lowerLimit = (int) (0.5 * currAge + 7) + 1;
            
            // Find the count of people within valid age range
            int lower = lowerBound(ages, lowerLimit);
            int upper = upperBound(ages, currAge);
            
            // Calculate number of valid requests for this person
            int validRequests = Math.max(0, upper - lower);
            
            // If we're counting from the same position as current age,
            // don't count request to self
            if (lower <= i && i < upper) {
                validRequests--;
            }
            
            res += validRequests;
        }
        
        return res;
    }
}