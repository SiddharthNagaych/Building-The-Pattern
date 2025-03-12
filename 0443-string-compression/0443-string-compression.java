class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int left = 0, right = 1; // Start with right = 1
        int write = 0; // Pointer to write compressed data

        while (right <= n) { // <= n to handle last character properly
            // If end of array is reached OR next character is different
            if (right == n || chars[right] != chars[left]) {
                chars[write++] = chars[left]; // Write the character

                if (right - left > 1) { // If count > 1, write count
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[write++] = c;
                    }
                }

                left = right;
               // Move right pointer // Move left to start of next group
            }
              right++; 
            
           
        }

        return write; // Return new compressed length
    }
}
